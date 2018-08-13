package com.qasymphony.ci.plugin.model;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import org.apache.commons.lang.StringUtils;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class ToscaIntegration extends AbstractDescribableImpl<ToscaIntegration> implements ExternalTool {

    @DataBoundConstructor
    public ToscaIntegration(String command, String arguments, String resultPath) {
        this.resultPath = resultPath;
        this.command = command;
        this.arguments = arguments;
    }
    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public boolean validate() {
        return StringUtils.isNotEmpty(command) && StringUtils.isNotEmpty(this.arguments);
    }

    @Override
    public String getResultPath() {
        return resultPath;
    }

    @Override
    public void setResultPath(String value) {
        this.resultPath = value;
    }

    private String arguments;
    private String command ;
    private String resultPath;

    @Symbol("executeToscaTests")
    @Extension
    public static class DescriptorImp extends Descriptor<ToscaIntegration> {
        public String getDisplayName() {
            return "";
        }
    }
}