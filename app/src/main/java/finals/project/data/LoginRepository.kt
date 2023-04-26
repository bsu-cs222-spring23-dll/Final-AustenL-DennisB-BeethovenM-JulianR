package finals.project.data

import finals.project.data.model.LoggedInUser
import com.google.firebase.auth.FirebaseAuth

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {
    var user: LoggedInUser? = null
        private set

    //creates user/signs in to user if one already exists for provided email
    fun login(username: String, password: String): Result<LoggedInUser> {
        val result = dataSource.login(username)
        if (result is Result.Success) {
            setLoggedInUser(result.data)
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(username, password)
            FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
        }
        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
    }

}