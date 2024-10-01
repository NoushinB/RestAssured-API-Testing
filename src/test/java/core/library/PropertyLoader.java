package core.library;

public class PropertyLoader {

    private static volatile PropertyLoader instance;

    public static PropertyLoader getInstance() {
        if (instance == null) {
            synchronized (PropertyLoader.class) {
                if (instance == null) {
                    instance = new PropertyLoader();
                }
            }
        }
        return instance;
    }

    /*
    Property to save the base URL
     */
    private String baseUrl;

    /*
     Base URL property getter

     @return the baseUrl value
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /*Base URL property setter

      @param baseUrl new value for baseUrl
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}

