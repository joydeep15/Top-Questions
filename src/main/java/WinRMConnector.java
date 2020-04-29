
import io.cloudsoft.winrm4j.client.WinRmClientContext;
import io.cloudsoft.winrm4j.winrm.WinRmTool;
import io.cloudsoft.winrm4j.winrm.WinRmToolResponse;
import org.apache.http.client.config.AuthSchemes;


public class WinRMConnector  {


    public WinRMConnector() {
    }


    public void connect(){
        WinRmClientContext context = WinRmClientContext.newInstance();


        WinRmTool tool = WinRmTool.Builder.builder(
                "ibndev001805.bpc.broadcom.net",
                "ibndev001805\\administrator",
                "interOP@001805")
                .authenticationScheme(AuthSchemes.NTLM)
                .port(WinRmTool.DEFAULT_WINRM_PORT)
                .useHttps(true)
                .build();

        tool.setConnectionTimeout(10000l);

        WinRmToolResponse response = tool.executePs("hostname");
        System.out.println(response.getStdOut());
        context.shutdown();
    }


}
