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

package com.microsoft.windowsazure.management.storage.models;

import java.util.HashMap;

/**
* Parameters supplied to the Create Storage Account operation.
*/
public class StorageAccountCreateParameters {
    private String affinityGroup;
    
    /**
    * Optional. Required if Location is not specified. The name of an existing
    * affinity group in the specified subscription.  You can include either a
    * Location or AffinityGroup element in the request body, but not both. To
    * list available affinity groups, use the List Affinity Groups operation.
    * @return The AffinityGroup value.
    */
    public String getAffinityGroup() {
        return this.affinityGroup;
    }
    
    /**
    * Optional. Required if Location is not specified. The name of an existing
    * affinity group in the specified subscription.  You can include either a
    * Location or AffinityGroup element in the request body, but not both. To
    * list available affinity groups, use the List Affinity Groups operation.
    * @param affinityGroupValue The AffinityGroup value.
    */
    public void setAffinityGroup(final String affinityGroupValue) {
        this.affinityGroup = affinityGroupValue;
    }
    
    private String description;
    
    /**
    * Optional. A description for the storage account. The description may be
    * up to 1024 characters in length.
    * @return The Description value.
    */
    public String getDescription() {
        return this.description;
    }
    
    /**
    * Optional. A description for the storage account. The description may be
    * up to 1024 characters in length.
    * @param descriptionValue The Description value.
    */
    public void setDescription(final String descriptionValue) {
        this.description = descriptionValue;
    }
    
    private HashMap<String, String> extendedProperties;
    
    /**
    * Optional. Represents the name of an extended storage account property.
    * Each extended property must have both a defined name and value. You can
    * have a maximum of 50 extended property name/value pairs.  The maximum
    * length of the Name element is 64 characters, only alphanumeric
    * characters and underscores are valid in the Name, and the name must
    * start with a letter. Attempting to use other characters, starting the
    * Name with a non-letter character, or entering a name that is identical
    * to that of another extended property owned by the same storage account,
    * will result in a status code 400 (Bad Request) error.  Each extended
    * property value has a maximum length of 255 characters.
    * @return The ExtendedProperties value.
    */
    public HashMap<String, String> getExtendedProperties() {
        return this.extendedProperties;
    }
    
    /**
    * Optional. Represents the name of an extended storage account property.
    * Each extended property must have both a defined name and value. You can
    * have a maximum of 50 extended property name/value pairs.  The maximum
    * length of the Name element is 64 characters, only alphanumeric
    * characters and underscores are valid in the Name, and the name must
    * start with a letter. Attempting to use other characters, starting the
    * Name with a non-letter character, or entering a name that is identical
    * to that of another extended property owned by the same storage account,
    * will result in a status code 400 (Bad Request) error.  Each extended
    * property value has a maximum length of 255 characters.
    * @param extendedPropertiesValue The ExtendedProperties value.
    */
    public void setExtendedProperties(final HashMap<String, String> extendedPropertiesValue) {
        this.extendedProperties = extendedPropertiesValue;
    }
    
    private boolean geoReplicationEnabled;
    
    /**
    * Optional. Specifies whether the storage account is created with the
    * geo-replication enabled. If the element is not included in the request
    * body, the default value is true. If set to true, the data in the storage
    * account is replicated across more than one geographic location so as to
    * enable resilience in the face of catastrophic service loss.
    * @return The GeoReplicationEnabled value.
    */
    public boolean isGeoReplicationEnabled() {
        return this.geoReplicationEnabled;
    }
    
    /**
    * Optional. Specifies whether the storage account is created with the
    * geo-replication enabled. If the element is not included in the request
    * body, the default value is true. If set to true, the data in the storage
    * account is replicated across more than one geographic location so as to
    * enable resilience in the face of catastrophic service loss.
    * @param geoReplicationEnabledValue The GeoReplicationEnabled value.
    */
    public void setGeoReplicationEnabled(final boolean geoReplicationEnabledValue) {
        this.geoReplicationEnabled = geoReplicationEnabledValue;
    }
    
    private String label;
    
    /**
    * Required. A name for the storage account specified as abase64-encoded
    * string. The name may be up to 100 characters inlength. The name can be
    * used identify the storage account for yourtracking purposes.
    * @return The Label value.
    */
    public String getLabel() {
        if (this.label == null) {
            return this.getName();
        } else {
            return this.label;
        }
    }
    
    /**
    * Required. A name for the storage account specified as abase64-encoded
    * string. The name may be up to 100 characters inlength. The name can be
    * used identify the storage account for yourtracking purposes.
    * @param labelValue The Label value.
    */
    public void setLabel(final String labelValue) {
        this.label = labelValue;
    }
    
    private String location;
    
    /**
    * Optional. Required if AffinityGroup is not specified. The location where
    * the storage account is created.  You can include either a Location or
    * AffinityGroup element in the request body, but not both. To list
    * available locations, use the List Locations operation.
    * @return The Location value.
    */
    public String getLocation() {
        return this.location;
    }
    
    /**
    * Optional. Required if AffinityGroup is not specified. The location where
    * the storage account is created.  You can include either a Location or
    * AffinityGroup element in the request body, but not both. To list
    * available locations, use the List Locations operation.
    * @param locationValue The Location value.
    */
    public void setLocation(final String locationValue) {
        this.location = locationValue;
    }
    
    private String name;
    
    /**
    * Required. A name for the storage account that is unique within Windows
    * Azure. Storage account names must be between 3 and 24 characters in
    * length and use numbers and lower-case letters only.  This name is the
    * DNS prefix name and can be used to access blobs, queues, and tables in
    * the storage account.  For example:
    * http://ServiceName.blob.core.windows.net/mycontainer/
    * @return The Name value.
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * Required. A name for the storage account that is unique within Windows
    * Azure. Storage account names must be between 3 and 24 characters in
    * length and use numbers and lower-case letters only.  This name is the
    * DNS prefix name and can be used to access blobs, queues, and tables in
    * the storage account.  For example:
    * http://ServiceName.blob.core.windows.net/mycontainer/
    * @param nameValue The Name value.
    */
    public void setName(final String nameValue) {
        this.name = nameValue;
    }
    
    /**
    * Initializes a new instance of the StorageAccountCreateParameters class.
    *
    */
    public StorageAccountCreateParameters() {
        this.extendedProperties = new HashMap<String, String>();
    }
}
