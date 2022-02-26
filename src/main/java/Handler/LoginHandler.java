package Handler;

import DAO.Mongo.DatabaseManager;
import DAO.UserDao;
import Model.User;
import Request.LoginRequest;
import Response.LoginResponse;

public class LoginHandler extends Handler<LoginRequest, LoginResponse> {
    @Override
    protected LoginResponse handle(LoginRequest request) {
        UserDao dao = DatabaseManager.getInstance().createUserDao();
        User userToBeLoggedIn = dao.getUser(request.getUsername(), request.getPassword());
        return new LoginResponse(true, userToBeLoggedIn);
    }

    @Override
    protected LoginResponse fail(Exception e) {
        return new LoginResponse(false, e.getMessage());
    }

    @Override
    protected LoginRequest emptyRequest() {
        return new LoginRequest();
    }
}
