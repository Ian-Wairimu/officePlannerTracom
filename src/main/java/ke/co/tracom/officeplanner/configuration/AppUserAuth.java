package ke.co.tracom.officeplanner.configuration;

public enum AppUserAuth {
        USER_READ("user:read"),
        USER_WRITE("user:write");

        private final String authentication;

        AppUserAuth(String authentication){
                this.authentication = authentication;
        }

        public String getAuthentication() {
                return authentication;
        }
}
