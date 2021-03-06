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

package com.microsoft.windowsazure.management.scheduler.models;

/**
* Parameters supplied to the Update Job Collection operation.
*/
public class JobCollectionUpdateParameters {
    private String eTag;
    
    /**
    * Required. The ETag of the job collection to update.  The update will fail
    * ifthe ETag doesn't match.
    * @return The ETag value.
    */
    public String getETag() {
        return this.eTag;
    }
    
    /**
    * Required. The ETag of the job collection to update.  The update will fail
    * ifthe ETag doesn't match.
    * @param eTagValue The ETag value.
    */
    public void setETag(final String eTagValue) {
        this.eTag = eTagValue;
    }
    
    private JobCollectionIntrinsicSettings intrinsicSettings;
    
    /**
    * Optional. Intrinsic settings for the scheduler job collections.
    * @return The IntrinsicSettings value.
    */
    public JobCollectionIntrinsicSettings getIntrinsicSettings() {
        return this.intrinsicSettings;
    }
    
    /**
    * Optional. Intrinsic settings for the scheduler job collections.
    * @param intrinsicSettingsValue The IntrinsicSettings value.
    */
    public void setIntrinsicSettings(final JobCollectionIntrinsicSettings intrinsicSettingsValue) {
        this.intrinsicSettings = intrinsicSettingsValue;
    }
    
    private String label;
    
    /**
    * Optional. Label for the resource.
    * @return The Label value.
    */
    public String getLabel() {
        return this.label;
    }
    
    /**
    * Optional. Label for the resource.
    * @param labelValue The Label value.
    */
    public void setLabel(final String labelValue) {
        this.label = labelValue;
    }
    
    private String schemaVersion;
    
    /**
    * Optional. The version of the Intrinsic Properties for your Resource. If
    * not specified, you must conform to the contract resource version you
    * registered as default.
    * @return The SchemaVersion value.
    */
    public String getSchemaVersion() {
        return this.schemaVersion;
    }
    
    /**
    * Optional. The version of the Intrinsic Properties for your Resource. If
    * not specified, you must conform to the contract resource version you
    * registered as default.
    * @param schemaVersionValue The SchemaVersion value.
    */
    public void setSchemaVersion(final String schemaVersionValue) {
        this.schemaVersion = schemaVersionValue;
    }
    
    /**
    * Initializes a new instance of the JobCollectionUpdateParameters class.
    *
    */
    public JobCollectionUpdateParameters() {
    }
    
    /**
    * Initializes a new instance of the JobCollectionUpdateParameters class
    * with required arguments.
    *
    * @param eTag The ETag of the job collection to update.  The update will
    * fail ifthe ETag doesn't match.
    */
    public JobCollectionUpdateParameters(String eTag) {
        if (eTag == null) {
            throw new NullPointerException("eTag");
        }
        this.setETag(eTag);
    }
}
