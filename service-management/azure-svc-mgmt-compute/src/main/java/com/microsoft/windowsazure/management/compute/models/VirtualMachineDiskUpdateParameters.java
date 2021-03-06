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

import java.net.URI;

/**
* Parameters supplied to the Update Virtual Disk Image operation.
*/
public class VirtualMachineDiskUpdateParameters {
    private Boolean hasOperatingSystem;
    
    /**
    * Optional. Specifies whether the disk contains an operating system. Note:
    * Only a disk with an operating system installed can be mounted as OS
    * Drive.
    * @return The HasOperatingSystem value.
    */
    public Boolean isHasOperatingSystem() {
        return this.hasOperatingSystem;
    }
    
    /**
    * Optional. Specifies whether the disk contains an operating system. Note:
    * Only a disk with an operating system installed can be mounted as OS
    * Drive.
    * @param hasOperatingSystemValue The HasOperatingSystem value.
    */
    public void setHasOperatingSystem(final Boolean hasOperatingSystemValue) {
        this.hasOperatingSystem = hasOperatingSystemValue;
    }
    
    private String label;
    
    /**
    * Required. Specifies the friendly name of the disk.
    * @return The Label value.
    */
    public String getLabel() {
        return this.label;
    }
    
    /**
    * Required. Specifies the friendly name of the disk.
    * @param labelValue The Label value.
    */
    public void setLabel(final String labelValue) {
        this.label = labelValue;
    }
    
    private URI mediaLinkUri;
    
    /**
    * Optional. Specifies the location of the blob in Azure storage. The blob
    * location must belong to a storage account in the subscription specified
    * by the SubscriptionId value in the operation call. Example:
    * http://example.blob.core.windows.net/disks/mydisk.vhd.
    * @return The MediaLinkUri value.
    */
    public URI getMediaLinkUri() {
        return this.mediaLinkUri;
    }
    
    /**
    * Optional. Specifies the location of the blob in Azure storage. The blob
    * location must belong to a storage account in the subscription specified
    * by the SubscriptionId value in the operation call. Example:
    * http://example.blob.core.windows.net/disks/mydisk.vhd.
    * @param mediaLinkUriValue The MediaLinkUri value.
    */
    public void setMediaLinkUri(final URI mediaLinkUriValue) {
        this.mediaLinkUri = mediaLinkUriValue;
    }
    
    private String name;
    
    /**
    * Required. Specifies a name for the disk. Azure uses the name to identify
    * the disk when creating virtual machines from the disk.
    * @return The Name value.
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * Required. Specifies a name for the disk. Azure uses the name to identify
    * the disk when creating virtual machines from the disk.
    * @param nameValue The Name value.
    */
    public void setName(final String nameValue) {
        this.name = nameValue;
    }
    
    private String operatingSystemType;
    
    /**
    * Optional. The operating system type of the disk. Possible values are:
    * Linux or Windows.
    * @return The OperatingSystemType value.
    */
    public String getOperatingSystemType() {
        return this.operatingSystemType;
    }
    
    /**
    * Optional. The operating system type of the disk. Possible values are:
    * Linux or Windows.
    * @param operatingSystemTypeValue The OperatingSystemType value.
    */
    public void setOperatingSystemType(final String operatingSystemTypeValue) {
        this.operatingSystemType = operatingSystemTypeValue;
    }
    
    private Integer resizedSizeInGB;
    
    /**
    * Optional. Resizes the underlying blob to the indicated size in GB.To use
    * the ResizedSizeInGB property, the version header should be at least
    * 2014-10-01.
    * @return The ResizedSizeInGB value.
    */
    public Integer getResizedSizeInGB() {
        return this.resizedSizeInGB;
    }
    
    /**
    * Optional. Resizes the underlying blob to the indicated size in GB.To use
    * the ResizedSizeInGB property, the version header should be at least
    * 2014-10-01.
    * @param resizedSizeInGBValue The ResizedSizeInGB value.
    */
    public void setResizedSizeInGB(final Integer resizedSizeInGBValue) {
        this.resizedSizeInGB = resizedSizeInGBValue;
    }
    
    /**
    * Initializes a new instance of the VirtualMachineDiskUpdateParameters
    * class.
    *
    */
    public VirtualMachineDiskUpdateParameters() {
    }
    
    /**
    * Initializes a new instance of the VirtualMachineDiskUpdateParameters
    * class with required arguments.
    *
    * @param label Specifies the friendly name of the disk.
    * @param name Specifies a name for the disk. Azure uses the name to
    * identify the disk when creating virtual machines from the disk.
    */
    public VirtualMachineDiskUpdateParameters(String label, String name) {
        if (label == null) {
            throw new NullPointerException("label");
        }
        if (name == null) {
            throw new NullPointerException("name");
        }
        this.setLabel(label);
        this.setName(name);
    }
}
