package android.myapplicationdev.com.p03_classjournal;

/**
 * Created by 15039836 on 2/5/2017.
 */

public class rowForModule {
    String moduleCode;
    String moduleName;

    public rowForModule(String moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
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
}
