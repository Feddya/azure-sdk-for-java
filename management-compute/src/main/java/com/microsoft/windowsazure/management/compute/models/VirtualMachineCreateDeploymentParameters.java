/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.compute.models;

import java.util.ArrayList;

/**
* Parameters supplied to the Create Virtual Machine Deployment operation.
*/
public class VirtualMachineCreateDeploymentParameters
{
    private DeploymentSlot deploymentSlot;
    
    /**
    * Required. Specifies the environment in which to deploy the virtual
    * machine.  Possible values are: Staging, Production.
    */
    public DeploymentSlot getDeploymentSlot() { return this.deploymentSlot; }
    
    /**
    * Required. Specifies the environment in which to deploy the virtual
    * machine.  Possible values are: Staging, Production.
    */
    public void setDeploymentSlot(DeploymentSlot deploymentSlot) { this.deploymentSlot = deploymentSlot; }
    
    private DnsSettings dnsSettings;
    
    /**
    * Optional. Contains a list of DNS servers to associate with themachine.
    */
    public DnsSettings getDnsSettings() { return this.dnsSettings; }
    
    /**
    * Optional. Contains a list of DNS servers to associate with themachine.
    */
    public void setDnsSettings(DnsSettings dnsSettings) { this.dnsSettings = dnsSettings; }
    
    private String label;
    
    /**
    * Required. A name for the hosted service. The name can be up to 100
    * characters in length.  It is recommended that the label be unique within
    * the subscription. The name can be used identify the hosted service for
    * tracking purposes.
    */
    public String getLabel() { return this.label; }
    
    /**
    * Required. A name for the hosted service. The name can be up to 100
    * characters in length.  It is recommended that the label be unique within
    * the subscription. The name can be used identify the hosted service for
    * tracking purposes.
    */
    public void setLabel(String label) { this.label = label; }
    
    private String name;
    
    /**
    * Required. A name for the deployment. The deployment name must be unique
    * among other deployments for the hosted service.
    */
    public String getName() { return this.name; }
    
    /**
    * Required. A name for the deployment. The deployment name must be unique
    * among other deployments for the hosted service.
    */
    public void setName(String name) { this.name = name; }
    
    private String reservedIPName;
    
    /**
    * Optional and Preview Only. Specifies the name of an existing reserved IP
    * to which the deployment will belong. Reserved IPs are created by calling
    * the Create Reserved IP operation.
    */
    public String getReservedIPName() { return this.reservedIPName; }
    
    /**
    * Optional and Preview Only. Specifies the name of an existing reserved IP
    * to which the deployment will belong. Reserved IPs are created by calling
    * the Create Reserved IP operation.
    */
    public void setReservedIPName(String reservedIPName) { this.reservedIPName = reservedIPName; }
    
    private ArrayList<Role> roles;
    
    /**
    * Required. Contains the provisioning details for the new virtual machine
    * deployment.
    */
    public ArrayList<Role> getRoles() { return this.roles; }
    
    /**
    * Required. Contains the provisioning details for the new virtual machine
    * deployment.
    */
    public void setRoles(ArrayList<Role> roles) { this.roles = roles; }
    
    private String virtualNetworkName;
    
    /**
    * Optional. Specifies the name of an existing virtual network to which the
    * deployment will belong.  Virtual networks are created by calling the Set
    * Network Configuration operation.
    */
    public String getVirtualNetworkName() { return this.virtualNetworkName; }
    
    /**
    * Optional. Specifies the name of an existing virtual network to which the
    * deployment will belong.  Virtual networks are created by calling the Set
    * Network Configuration operation.
    */
    public void setVirtualNetworkName(String virtualNetworkName) { this.virtualNetworkName = virtualNetworkName; }
    
    /**
    * Initializes a new instance of the
    * VirtualMachineCreateDeploymentParameters class.
    *
    */
    public VirtualMachineCreateDeploymentParameters()
    {
        this.roles = new ArrayList<Role>();
    }
}
