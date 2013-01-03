package eu.vranckaert.worktime.dao.web;

import eu.vranckaert.worktime.exceptions.account.*;
import eu.vranckaert.worktime.exceptions.network.NoNetworkConnectionException;
import eu.vranckaert.worktime.model.User;
import eu.vranckaert.worktime.web.json.JsonWebService;
import eu.vranckaert.worktime.web.json.exception.GeneralWebException;

/**
 * User: Dirk Vranckaert
 * Date: 12/12/12
 * Time: 11:36
 */
public interface AccountWebDao extends JsonWebService {
    /**
     * Login the user with the specified email and password to the WorkTime webservice.
     * @param email The email.
     * @param password The password in plain text.
     * @return The session key of the registered user.
     * @throws NoNetworkConnectionException No working network connection is found.
     * @throws GeneralWebException Some kind of exception occurred during the web request.
     * @throws LoginCredentialsMismatchException The credentials provided are not correct and so the user is not logged
     * in!
     */
    String login(String email, String password) throws NoNetworkConnectionException, GeneralWebException, LoginCredentialsMismatchException;

    /**
     * Register a new user-account with the provided details to the WorkTime webservice.
     * @param email The email of the user.
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param password The chosen password in plain text.
     * @return The session key of the registered user.
     * @throws NoNetworkConnectionException No working network connection is found.
     * @throws GeneralWebException Some kind of exception occurred during the web request.
     * @throws RegisterEmailAlreadyInUseException If an account already exists for this email address.
     * @throws PasswordLengthValidationException If the password length is invalid (< 6 or > 30 characters).
     */
    String register(String email, String firstName, String lastName, String password) throws NoNetworkConnectionException, GeneralWebException, RegisterEmailAlreadyInUseException, PasswordLengthValidationException, RegisterFieldRequiredException;

    /**
     * Loads the profile of a certain user.
     * @param user A {@link User} object that contains at least the email address of the user and the session key with
     *             which the user has logged in.
     * @return The full user profile.
     * @throws NoNetworkConnectionException No working network connection is found.
     * @throws GeneralWebException Some kind of exception occurred during the web request.
     * @throws UserNotLoggedInException The user is not logged in, authentication failed...
     */
    User loadProfile(User user) throws NoNetworkConnectionException, GeneralWebException, UserNotLoggedInException;

    /**
     * Logout the currently logged in user using the email and session key provided in the {@link User object}.
     * @param user The logged in user.
     */
    void logout(User user);
}