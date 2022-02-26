package Handler;

import DAO.Mongo.DatabaseManager;
import DAO.UserDao;
import Model.User;
import Request.RegisterRequest;
import Response.RegisterResponse;

public class RegisterHandler extends Handler<RegisterRequest, RegisterResponse> {
    @Override
    protected RegisterResponse handle(RegisterRequest request) {
        UserDao dao = DatabaseManager.getInstance().createUserDao();
        User newUser = new User(request.getUsername(), request.getPassword());
        dao.createUser(newUser);
        return new RegisterResponse(true, newUser, "Sucess!");
    }

    @Override
    protected RegisterResponse fail(Exception e) {
        return new RegisterResponse(false, e.getMessage());
    }

    @Override
    protected RegisterRequest emptyRequest() {
        return new RegisterRequest();
    }
}
