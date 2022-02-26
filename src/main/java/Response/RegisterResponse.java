package Response;

import Model.User;

public class RegisterResponse extends Response {
    private boolean _success;
    private String _message;
    private User _user;

    public RegisterResponse(boolean success, User user, String message){
        _success = success;
        _user = user;
        _message = message;
    }

    public RegisterResponse(boolean _success, String _message) {
        this._success = _success;
        this._message = _message;
    }

    public boolean getSuccess(){
        return _success;
    }

    public User getUser() {return _user;}

    public String getMessage(){
        return _message;
    }
}
