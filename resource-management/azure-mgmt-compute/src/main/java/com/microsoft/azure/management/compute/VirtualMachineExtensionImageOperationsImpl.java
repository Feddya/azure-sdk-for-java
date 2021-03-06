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

package com.microsoft.azure.management.compute;

import com.microsoft.azure.management.compute.models.VirtualMachineExtensionImage;
import com.microsoft.azure.management.compute.models.VirtualMachineExtensionImageGetParameters;
import com.microsoft.azure.management.compute.models.VirtualMachineExtensionImageGetResponse;
import com.microsoft.azure.management.compute.models.VirtualMachineExtensionImageListTypesParameters;
import com.microsoft.azure.management.compute.models.VirtualMachineExtensionImageListVersionsParameters;
import com.microsoft.azure.management.compute.models.VirtualMachineImageResource;
import com.microsoft.azure.management.compute.models.VirtualMachineImageResourceList;
import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.utils.CollectionStringBuilder;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.tracing.CloudTracing;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.NullNode;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
* Operations for managing the virtual machine extension images in compute
* management.
*/
public class VirtualMachineExtensionImageOperationsImpl implements ServiceOperations<ComputeManagementClientImpl>, VirtualMachineExtensionImageOperations {
    /**
    * Initializes a new instance of the
    * VirtualMachineExtensionImageOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    VirtualMachineExtensionImageOperationsImpl(ComputeManagementClientImpl client) {
        this.client = client;
    }
    
    private ComputeManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.azure.management.compute.ComputeManagementClientImpl.
    * @return The Client value.
    */
    public ComputeManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * Gets a virtual machine extension image.
    *
    * @param parameters Optional.
    * @return The get virtual machine extension image operation response.
    */
    @Override
    public Future<VirtualMachineExtensionImageGetResponse> getAsync(final VirtualMachineExtensionImageGetParameters parameters) {
        return this.getClient().getExecutorService().submit(new Callable<VirtualMachineExtensionImageGetResponse>() { 
            @Override
            public VirtualMachineExtensionImageGetResponse call() throws Exception {
                return get(parameters);
            }
         });
    }
    
    /**
    * Gets a virtual machine extension image.
    *
    * @param parameters Optional.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    * @return The get virtual machine extension image operation response.
    */
    @Override
    public VirtualMachineExtensionImageGetResponse get(VirtualMachineExtensionImageGetParameters parameters) throws IOException, ServiceException, URISyntaxException {
        // Validate
        if (parameters != null) {
            if (parameters.getLocation() == null) {
                throw new NullPointerException("parameters.Location");
            }
            if (parameters.getPublisherName() == null) {
                throw new NullPointerException("parameters.PublisherName");
            }
            if (parameters.getType() == null) {
                throw new NullPointerException("parameters.Type");
            }
            if (parameters.getVersion() == null) {
                throw new NullPointerException("parameters.Version");
            }
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("parameters", parameters);
            CloudTracing.enter(invocationId, this, "getAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "";
        url = url + "/subscriptions/";
        if (this.getClient().getCredentials().getSubscriptionId() != null) {
            url = url + URLEncoder.encode(this.getClient().getCredentials().getSubscriptionId(), "UTF-8");
        }
        url = url + "/providers/";
        url = url + "Microsoft.Compute";
        url = url + "/locations/";
        if (parameters != null) {
            url = url + URLEncoder.encode(parameters.getLocation(), "UTF-8");
        }
        url = url + "/publishers/";
        if (parameters != null) {
            url = url + URLEncoder.encode(parameters.getPublisherName(), "UTF-8");
        }
        url = url + "/artifacttypes/vmextension/types/";
        if (parameters != null) {
            url = url + URLEncoder.encode(parameters.getType(), "UTF-8");
        }
        url = url + "/versions/";
        if (parameters != null) {
            url = url + URLEncoder.encode(parameters.getVersion(), "UTF-8");
        }
        ArrayList<String> queryParameters = new ArrayList<String>();
        queryParameters.add("api-version=" + "2015-06-15");
        if (queryParameters.size() > 0) {
            url = url + "?" + CollectionStringBuilder.join(queryParameters, "&");
        }
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        url = url.replace(" ", "%20");
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("Content-Type", "application/json");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromJson(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            VirtualMachineExtensionImageGetResponse result = null;
            // Deserialize Response
            if (statusCode == HttpStatus.SC_OK) {
                InputStream responseContent = httpResponse.getEntity().getContent();
                result = new VirtualMachineExtensionImageGetResponse();
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode responseDoc = null;
                String responseDocContent = IOUtils.toString(responseContent);
                if (responseDocContent == null == false && responseDocContent.length() > 0) {
                    responseDoc = objectMapper.readTree(responseDocContent);
                }
                
                if (responseDoc != null && responseDoc instanceof NullNode == false) {
                    VirtualMachineExtensionImage virtualMachineExtensionImageInstance = new VirtualMachineExtensionImage();
                    result.setVirtualMachineExtensionImage(virtualMachineExtensionImageInstance);
                    
                    JsonNode propertiesValue = responseDoc.get("properties");
                    if (propertiesValue != null && propertiesValue instanceof NullNode == false) {
                        JsonNode operatingSystemValue = propertiesValue.get("operatingSystem");
                        if (operatingSystemValue != null && operatingSystemValue instanceof NullNode == false) {
                            String operatingSystemInstance;
                            operatingSystemInstance = operatingSystemValue.getTextValue();
                            virtualMachineExtensionImageInstance.setOperatingSystem(operatingSystemInstance);
                        }
                        
                        JsonNode computeRoleValue = propertiesValue.get("computeRole");
                        if (computeRoleValue != null && computeRoleValue instanceof NullNode == false) {
                            String computeRoleInstance;
                            computeRoleInstance = computeRoleValue.getTextValue();
                            virtualMachineExtensionImageInstance.setComputeRole(computeRoleInstance);
                        }
                        
                        JsonNode handlerSchemaValue = propertiesValue.get("handlerSchema");
                        if (handlerSchemaValue != null && handlerSchemaValue instanceof NullNode == false) {
                            String handlerSchemaInstance;
                            handlerSchemaInstance = handlerSchemaValue.getTextValue();
                            virtualMachineExtensionImageInstance.setHandlerSchema(handlerSchemaInstance);
                        }
                        
                        JsonNode vmScaleSetEnabledValue = propertiesValue.get("vmScaleSetEnabled");
                        if (vmScaleSetEnabledValue != null && vmScaleSetEnabledValue instanceof NullNode == false) {
                            boolean vmScaleSetEnabledInstance;
                            vmScaleSetEnabledInstance = vmScaleSetEnabledValue.getBooleanValue();
                            virtualMachineExtensionImageInstance.setVMScaleSetEnabled(vmScaleSetEnabledInstance);
                        }
                        
                        JsonNode supportsMultipleExtensionsValue = propertiesValue.get("supportsMultipleExtensions");
                        if (supportsMultipleExtensionsValue != null && supportsMultipleExtensionsValue instanceof NullNode == false) {
                            boolean supportsMultipleExtensionsInstance;
                            supportsMultipleExtensionsInstance = supportsMultipleExtensionsValue.getBooleanValue();
                            virtualMachineExtensionImageInstance.setSupportsMultipleExtensions(supportsMultipleExtensionsInstance);
                        }
                    }
                    
                    JsonNode idValue = responseDoc.get("id");
                    if (idValue != null && idValue instanceof NullNode == false) {
                        String idInstance;
                        idInstance = idValue.getTextValue();
                        virtualMachineExtensionImageInstance.setId(idInstance);
                    }
                    
                    JsonNode nameValue = responseDoc.get("name");
                    if (nameValue != null && nameValue instanceof NullNode == false) {
                        String nameInstance;
                        nameInstance = nameValue.getTextValue();
                        virtualMachineExtensionImageInstance.setName(nameInstance);
                    }
                    
                    JsonNode locationValue = responseDoc.get("location");
                    if (locationValue != null && locationValue instanceof NullNode == false) {
                        String locationInstance;
                        locationInstance = locationValue.getTextValue();
                        virtualMachineExtensionImageInstance.setLocation(locationInstance);
                    }
                }
                
            }
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * Gets a list of virtual machine extension image types.
    *
    * @param parameters Optional.
    * @return A list of virtual machine image resource information.
    */
    @Override
    public Future<VirtualMachineImageResourceList> listTypesAsync(final VirtualMachineExtensionImageListTypesParameters parameters) {
        return this.getClient().getExecutorService().submit(new Callable<VirtualMachineImageResourceList>() { 
            @Override
            public VirtualMachineImageResourceList call() throws Exception {
                return listTypes(parameters);
            }
         });
    }
    
    /**
    * Gets a list of virtual machine extension image types.
    *
    * @param parameters Optional.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A list of virtual machine image resource information.
    */
    @Override
    public VirtualMachineImageResourceList listTypes(VirtualMachineExtensionImageListTypesParameters parameters) throws IOException, ServiceException {
        // Validate
        if (parameters != null) {
            if (parameters.getLocation() == null) {
                throw new NullPointerException("parameters.Location");
            }
            if (parameters.getPublisherName() == null) {
                throw new NullPointerException("parameters.PublisherName");
            }
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("parameters", parameters);
            CloudTracing.enter(invocationId, this, "listTypesAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "";
        url = url + "/subscriptions/";
        if (this.getClient().getCredentials().getSubscriptionId() != null) {
            url = url + URLEncoder.encode(this.getClient().getCredentials().getSubscriptionId(), "UTF-8");
        }
        url = url + "/providers/";
        url = url + "Microsoft.Compute";
        url = url + "/locations/";
        if (parameters != null) {
            url = url + URLEncoder.encode(parameters.getLocation(), "UTF-8");
        }
        url = url + "/publishers/";
        if (parameters != null) {
            url = url + URLEncoder.encode(parameters.getPublisherName(), "UTF-8");
        }
        url = url + "/artifacttypes/vmextension/types";
        ArrayList<String> queryParameters = new ArrayList<String>();
        queryParameters.add("api-version=" + "2015-06-15");
        if (queryParameters.size() > 0) {
            url = url + "?" + CollectionStringBuilder.join(queryParameters, "&");
        }
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        url = url.replace(" ", "%20");
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("Content-Type", "application/json");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromJson(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            VirtualMachineImageResourceList result = null;
            // Deserialize Response
            if (statusCode == HttpStatus.SC_OK) {
                InputStream responseContent = httpResponse.getEntity().getContent();
                result = new VirtualMachineImageResourceList();
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode responseDoc = null;
                String responseDocContent = IOUtils.toString(responseContent);
                if (responseDocContent == null == false && responseDocContent.length() > 0) {
                    responseDoc = objectMapper.readTree(responseDocContent);
                }
                
                if (responseDoc != null && responseDoc instanceof NullNode == false) {
                    JsonNode resourcesArray = responseDoc;
                    if (resourcesArray != null && resourcesArray instanceof NullNode == false) {
                        for (JsonNode resourcesValue : ((ArrayNode) resourcesArray)) {
                            VirtualMachineImageResource virtualMachineImageResourceInstance = new VirtualMachineImageResource();
                            result.getResources().add(virtualMachineImageResourceInstance);
                            
                            JsonNode idValue = resourcesValue.get("id");
                            if (idValue != null && idValue instanceof NullNode == false) {
                                String idInstance;
                                idInstance = idValue.getTextValue();
                                virtualMachineImageResourceInstance.setId(idInstance);
                            }
                            
                            JsonNode nameValue = resourcesValue.get("name");
                            if (nameValue != null && nameValue instanceof NullNode == false) {
                                String nameInstance;
                                nameInstance = nameValue.getTextValue();
                                virtualMachineImageResourceInstance.setName(nameInstance);
                            }
                            
                            JsonNode locationValue = resourcesValue.get("location");
                            if (locationValue != null && locationValue instanceof NullNode == false) {
                                String locationInstance;
                                locationInstance = locationValue.getTextValue();
                                virtualMachineImageResourceInstance.setLocation(locationInstance);
                            }
                        }
                    }
                }
                
            }
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * Gets a list of virtual machine extension image versions.
    *
    * @param parameters Optional.
    * @return A list of virtual machine image resource information.
    */
    @Override
    public Future<VirtualMachineImageResourceList> listVersionsAsync(final VirtualMachineExtensionImageListVersionsParameters parameters) {
        return this.getClient().getExecutorService().submit(new Callable<VirtualMachineImageResourceList>() { 
            @Override
            public VirtualMachineImageResourceList call() throws Exception {
                return listVersions(parameters);
            }
         });
    }
    
    /**
    * Gets a list of virtual machine extension image versions.
    *
    * @param parameters Optional.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A list of virtual machine image resource information.
    */
    @Override
    public VirtualMachineImageResourceList listVersions(VirtualMachineExtensionImageListVersionsParameters parameters) throws IOException, ServiceException {
        // Validate
        if (parameters != null) {
            if (parameters.getLocation() == null) {
                throw new NullPointerException("parameters.Location");
            }
            if (parameters.getPublisherName() == null) {
                throw new NullPointerException("parameters.PublisherName");
            }
            if (parameters.getType() == null) {
                throw new NullPointerException("parameters.Type");
            }
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("parameters", parameters);
            CloudTracing.enter(invocationId, this, "listVersionsAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "";
        url = url + "/subscriptions/";
        if (this.getClient().getCredentials().getSubscriptionId() != null) {
            url = url + URLEncoder.encode(this.getClient().getCredentials().getSubscriptionId(), "UTF-8");
        }
        url = url + "/providers/";
        url = url + "Microsoft.Compute";
        url = url + "/locations/";
        if (parameters != null) {
            url = url + URLEncoder.encode(parameters.getLocation(), "UTF-8");
        }
        url = url + "/publishers/";
        if (parameters != null) {
            url = url + URLEncoder.encode(parameters.getPublisherName(), "UTF-8");
        }
        url = url + "/artifacttypes/vmextension/types/";
        if (parameters != null) {
            url = url + URLEncoder.encode(parameters.getType(), "UTF-8");
        }
        url = url + "/versions";
        ArrayList<String> queryParameters = new ArrayList<String>();
        queryParameters.add("api-version=" + "2015-06-15");
        if (parameters != null && parameters.getFilterExpression() != null) {
            queryParameters.add(parameters.getFilterExpression());
        }
        if (queryParameters.size() > 0) {
            url = url + "?" + CollectionStringBuilder.join(queryParameters, "&");
        }
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        url = url.replace(" ", "%20");
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("Content-Type", "application/json");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromJson(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            VirtualMachineImageResourceList result = null;
            // Deserialize Response
            if (statusCode == HttpStatus.SC_OK) {
                InputStream responseContent = httpResponse.getEntity().getContent();
                result = new VirtualMachineImageResourceList();
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode responseDoc = null;
                String responseDocContent = IOUtils.toString(responseContent);
                if (responseDocContent == null == false && responseDocContent.length() > 0) {
                    responseDoc = objectMapper.readTree(responseDocContent);
                }
                
                if (responseDoc != null && responseDoc instanceof NullNode == false) {
                    JsonNode resourcesArray = responseDoc;
                    if (resourcesArray != null && resourcesArray instanceof NullNode == false) {
                        for (JsonNode resourcesValue : ((ArrayNode) resourcesArray)) {
                            VirtualMachineImageResource virtualMachineImageResourceInstance = new VirtualMachineImageResource();
                            result.getResources().add(virtualMachineImageResourceInstance);
                            
                            JsonNode idValue = resourcesValue.get("id");
                            if (idValue != null && idValue instanceof NullNode == false) {
                                String idInstance;
                                idInstance = idValue.getTextValue();
                                virtualMachineImageResourceInstance.setId(idInstance);
                            }
                            
                            JsonNode nameValue = resourcesValue.get("name");
                            if (nameValue != null && nameValue instanceof NullNode == false) {
                                String nameInstance;
                                nameInstance = nameValue.getTextValue();
                                virtualMachineImageResourceInstance.setName(nameInstance);
                            }
                            
                            JsonNode locationValue = resourcesValue.get("location");
                            if (locationValue != null && locationValue instanceof NullNode == false) {
                                String locationInstance;
                                locationInstance = locationValue.getTextValue();
                                virtualMachineImageResourceInstance.setLocation(locationInstance);
                            }
                        }
                    }
                }
                
            }
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
}
