package android.myapplicationdev.com.p03_classjournal;

/**
 * Created by 15039836 on 2/5/2017.
 */

public class rowForModule {
    String moduleCode;
    String moduleName;
    String url;

    public rowForModule(String moduleCode, String moduleName, String url) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.url = url;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
