package com.ejada.telemoney.telemoney.esb.constant.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ESBDTO {

    private String serviceName;
    private String funcId;
    private String ip;
    private String port;
    private String path;
    private String SCId;
    private String branchId;
    private String branchName;
    private String userId;
    private String agentId;
    private String secInfo;
    private String secInfoType;
    private String version;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSCId() {
        return SCId;
    }

    public void setSCId(String SCId) {
        this.SCId = SCId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getSecInfo() {
        return secInfo;
    }

    public void setSecInfo(String secInfo) {
        this.secInfo = secInfo;
    }

    public String getSecInfoType() {
        return secInfoType;
    }

    public void setSecInfoType(String secInfoType) {
        this.secInfoType = secInfoType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ESBDTO{" +
                "serviceName='" + serviceName + '\'' +
                ", funcId='" + funcId + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", path='" + path + '\'' +
                ", SCId='" + SCId + '\'' +
                ", branchId='" + branchId + '\'' +
                ", branchName='" + branchName + '\'' +
                ", userId='" + userId + '\'' +
                ", agentId='" + agentId + '\'' +
                ", secInfo='" + secInfo + '\'' +
                ", secInfoType='" + secInfoType + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

	public static ESBDTO toDTO(JSONObject jsonObject) {
        ESBDTO esbDTO = new ESBDTO();
        esbDTO.setServiceName(jsonObject.getString("ServiceName") != null ? jsonObject.getString("ServiceName") : "");
        esbDTO.setFuncId(jsonObject.getString("FuncId") != null ? jsonObject.getString("FuncId") : "");
        esbDTO.setIp(jsonObject.getString("Ip") != null ? jsonObject.getString("Ip") : "");
        esbDTO.setPort(jsonObject.getString("Port") != null ? jsonObject.getString("Port") : "");
        esbDTO.setPath(jsonObject.getString("Path") != null ? jsonObject.getString("Path") : "");
        esbDTO.setSCId(jsonObject.getString("SCId") != null ? jsonObject.getString("SCId") : "");
        esbDTO.setBranchId(jsonObject.getString("BranchId") != null ? jsonObject.getString("BranchId") : "");
        esbDTO.setBranchName(jsonObject.getString("BranchName") != null ? jsonObject.getString("BranchName") : "");
        esbDTO.setUserId(jsonObject.getString("UserId") != null ? jsonObject.getString("UserId") : "");
        esbDTO.setAgentId(jsonObject.getString("AgentId") != null ? jsonObject.getString("AgentId") : "");
        esbDTO.setSecInfo(jsonObject.getString("SecInfo") != null ? jsonObject.getString("SecInfo") : "");
        esbDTO.setSecInfoType(jsonObject.getString("SecInfoType") != null ? jsonObject.getString("SecInfoType") : "");
        esbDTO.setVersion(jsonObject.getString("Version") != null ? jsonObject.getString("Version") : "");
        return esbDTO;
    }

    public static List<ESBDTO> fromJSONArray(JSONArray jsonArray) {
        List<ESBDTO> esbDTOList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            ESBDTO esbDTO = ESBDTO.toDTO(jsonObject);
            esbDTOList.add(esbDTO);
        }

        return esbDTOList;
    }
}

