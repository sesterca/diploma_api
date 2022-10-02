package clients;

public enum Endpoints {
    PETS("/pet/"),
    GET_PETS("/pet/findByStatus"),
    MAKE_ORDER("/store/order"),
    CREATE_USER("/user"),
    REFER_TO_USER("/user/"),
    LOGIN_USER("/user/login"),
    LOGOUT_USER("/user/logout");

    private String endpoint;
    Endpoints(String endpoint){this.endpoint = endpoint;}
    public String getEndpoint(){return endpoint;}
}
