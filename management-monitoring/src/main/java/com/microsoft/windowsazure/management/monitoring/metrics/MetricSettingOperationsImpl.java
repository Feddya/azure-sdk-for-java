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

package com.microsoft.windowsazure.management.monitoring.metrics;

import com.microsoft.windowsazure.core.OperationResponse;
import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.monitoring.metrics.models.AvailabilityMetricSettingValue;
import com.microsoft.windowsazure.management.monitoring.metrics.models.EndpointConfig;
import com.microsoft.windowsazure.management.monitoring.metrics.models.MetricSetting;
import com.microsoft.windowsazure.management.monitoring.metrics.models.MetricSettingCollection;
import com.microsoft.windowsazure.management.monitoring.metrics.models.MetricSettingListResponse;
import com.microsoft.windowsazure.management.monitoring.metrics.models.MetricSettingsPutParameters;
import com.microsoft.windowsazure.management.monitoring.metrics.models.NameConfig;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class MetricSettingOperationsImpl implements ServiceOperations<MetricsClientImpl>, MetricSettingOperations
{
    /**
    * Initializes a new instance of the MetricSettingOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    MetricSettingOperationsImpl(MetricsClientImpl client)
    {
        this.client = client;
    }
    
    private MetricsClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.monitoring.metrics.MetricsClientImpl.
    */
    public MetricsClientImpl getClient() { return this.client; }
    
    /**
    * The Put Metric Settings operation creates or updates the metric settings
    * for the resource.
    *
    * @param parameters Metric settings to be created or updated.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<OperationResponse> createOrUpdateAsync(final MetricSettingsPutParameters parameters)
    {
        return this.getClient().getExecutorService().submit(new Callable<OperationResponse>() { 
            @Override
            public OperationResponse call() throws Exception
            {
                return createOrUpdate(parameters);
            }
         });
    }
    
    /**
    * The Put Metric Settings operation creates or updates the metric settings
    * for the resource.
    *
    * @param parameters Metric settings to be created or updated.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public OperationResponse createOrUpdate(MetricSettingsPutParameters parameters) throws UnsupportedEncodingException, IOException, ServiceException
    {
        // Validate
        if (parameters == null)
        {
            throw new NullPointerException("parameters");
        }
        if (parameters.getMetricSetting() == null)
        {
            throw new NullPointerException("parameters.MetricSetting");
        }
        if (parameters.getMetricSetting().getResourceId() == null)
        {
            throw new NullPointerException("parameters.MetricSetting.ResourceId");
        }
        if (parameters.getMetricSetting().getValue() == null)
        {
            throw new NullPointerException("parameters.MetricSetting.Value");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace)
        {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("parameters", parameters);
            CloudTracing.enter(invocationId, this, "createOrUpdateAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/services/monitoring/metricsettings";
        
        // Create HTTP transport objects
        HttpPut httpRequest = new HttpPut(url);
        
        // Set Headers
        httpRequest.setHeader("Accept", "application/json");
        httpRequest.setHeader("Content-Type", "application/json");
        httpRequest.setHeader("x-ms-version", "2013-10-01");
        
        // Serialize Request
        String requestContent = null;
        JsonNode requestDoc = null;
        
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode metricSettingValue = objectMapper.createObjectNode();
        requestDoc = metricSettingValue;
        
        metricSettingValue.put("ResourceId", parameters.getMetricSetting().getResourceId());
        
        if (parameters.getMetricSetting().getNamespace() != null)
        {
            metricSettingValue.put("Namespace", parameters.getMetricSetting().getNamespace());
        }
        
        ObjectNode valueValue = objectMapper.createObjectNode();
        metricSettingValue.put("Value", valueValue);
        valueValue.put("odata.type", parameters.getMetricSetting().getValue().getClass().getName());
        if (parameters.getMetricSetting().getValue().getClass().isInstance(AvailabilityMetricSettingValue.class))
        {
            AvailabilityMetricSettingValue derived = ((AvailabilityMetricSettingValue)parameters.getMetricSetting().getValue());
            
            if (derived.getAvailableLocations() != null)
            {
                ArrayNode availableLocationsArray = objectMapper.createArrayNode();
                for (NameConfig availableLocationsItem : derived.getAvailableLocations())
                {
                    ObjectNode nameConfigValue = objectMapper.createObjectNode();
                    availableLocationsArray.add(nameConfigValue);
                    
                    if (availableLocationsItem.getName() != null)
                    {
                        nameConfigValue.put("Name", availableLocationsItem.getName());
                    }
                    
                    if (availableLocationsItem.getDisplayName() != null)
                    {
                        nameConfigValue.put("DisplayName", availableLocationsItem.getDisplayName());
                    }
                }
                valueValue.put("AvailableLocations", availableLocationsArray);
            }
            
            if (derived.getEndpoints() != null)
            {
                ArrayNode endpointsArray = objectMapper.createArrayNode();
                for (EndpointConfig endpointsItem : derived.getEndpoints())
                {
                    ObjectNode endpointConfigValue = objectMapper.createObjectNode();
                    endpointsArray.add(endpointConfigValue);
                    
                    if (endpointsItem.getConfigId() != null)
                    {
                        endpointConfigValue.put("ConfigId", endpointsItem.getConfigId());
                    }
                    
                    if (endpointsItem.getName() != null)
                    {
                        endpointConfigValue.put("Name", endpointsItem.getName());
                    }
                    
                    if (endpointsItem.getLocation() != null)
                    {
                        endpointConfigValue.put("Location", endpointsItem.getLocation());
                    }
                    
                    if (endpointsItem.getUrl() != null)
                    {
                        endpointConfigValue.put("Url", endpointsItem.getUrl().toString());
                    }
                }
                valueValue.put("Endpoints", endpointsArray);
            }
        }
        
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, requestDoc);
        requestContent = stringWriter.toString();
        StringEntity entity = new StringEntity(requestContent);
        httpRequest.setEntity(entity);
        httpRequest.setHeader("Content-Type", "application/json");
        
        // Send Request
        HttpResponse httpResponse = null;
        if (shouldTrace)
        {
            CloudTracing.sendRequest(invocationId, httpRequest);
        }
        httpResponse = this.getClient().getHttpClient().execute(httpRequest);
        if (shouldTrace)
        {
            CloudTracing.receiveResponse(invocationId, httpResponse);
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            ServiceException ex = ServiceException.createFromJson(httpRequest, requestContent, httpResponse, httpResponse.getEntity());
            if (shouldTrace)
            {
                CloudTracing.error(invocationId, ex);
            }
            throw ex;
        }
        
        // Create Result
        OperationResponse result = null;
        result = new OperationResponse();
        result.setStatusCode(statusCode);
        if (httpResponse.getHeaders("x-ms-request-id").length > 0)
        {
            result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
        }
        
        if (shouldTrace)
        {
            CloudTracing.exit(invocationId, result);
        }
        return result;
    }
    
    /**
    * The List Metric Settings operation lists the metric settings for the
    * resource.
    *
    * @param resourceId The id of the resource.
    * @param metricNamespace The namespace of the metrics.
    * @return The list metric settings operation response.
    */
    @Override
    public Future<MetricSettingListResponse> listAsync(final String resourceId, final String metricNamespace)
    {
        return this.getClient().getExecutorService().submit(new Callable<MetricSettingListResponse>() { 
            @Override
            public MetricSettingListResponse call() throws Exception
            {
                return list(resourceId, metricNamespace);
            }
         });
    }
    
    /**
    * The List Metric Settings operation lists the metric settings for the
    * resource.
    *
    * @param resourceId The id of the resource.
    * @param metricNamespace The namespace of the metrics.
    * @return The list metric settings operation response.
    */
    @Override
    public MetricSettingListResponse list(String resourceId, String metricNamespace) throws IOException, ServiceException, URISyntaxException, ParseException
    {
        // Validate
        if (resourceId == null)
        {
            throw new NullPointerException("resourceId");
        }
        if (metricNamespace == null)
        {
            throw new NullPointerException("metricNamespace");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace)
        {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("resourceId", resourceId);
            tracingParameters.put("metricNamespace", metricNamespace);
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String url = this.getClient().getBaseUri() + "/" + this.getClient().getCredentials().getSubscriptionId() + "/services/monitoring/metricsettings?";
        url = url + "&resourceId=" + URLEncoder.encode(resourceId);
        url = url + "&namespace=" + URLEncoder.encode(metricNamespace);
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("Accept", "application/json");
        httpRequest.setHeader("x-ms-version", "2013-10-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        if (shouldTrace)
        {
            CloudTracing.sendRequest(invocationId, httpRequest);
        }
        httpResponse = this.getClient().getHttpClient().execute(httpRequest);
        if (shouldTrace)
        {
            CloudTracing.receiveResponse(invocationId, httpResponse);
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200)
        {
            ServiceException ex = ServiceException.createFromJson(httpRequest, null, httpResponse, httpResponse.getEntity());
            if (shouldTrace)
            {
                CloudTracing.error(invocationId, ex);
            }
            throw ex;
        }
        
        // Create Result
        MetricSettingListResponse result = null;
        // Deserialize Response
        InputStream responseContent = httpResponse.getEntity().getContent();
        result = new MetricSettingListResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseDoc = objectMapper.readTree(responseContent);
        
        if (responseDoc != null)
        {
            MetricSettingCollection metricSettingCollectionInstance = new MetricSettingCollection();
            result.setMetricSettingCollection(metricSettingCollectionInstance);
            
            ArrayNode valueArray = ((ArrayNode)responseDoc.get("Value"));
            if (valueArray != null)
            {
                for (JsonNode valueValue : valueArray)
                {
                    MetricSetting metricSettingInstance = new MetricSetting();
                    metricSettingCollectionInstance.getValue().add(metricSettingInstance);
                    
                    JsonNode resourceIdValue = valueValue.get("ResourceId");
                    if (resourceIdValue != null)
                    {
                        String resourceIdInstance;
                        resourceIdInstance = resourceIdValue.getTextValue();
                        metricSettingInstance.setResourceId(resourceIdInstance);
                    }
                    
                    JsonNode namespaceValue = valueValue.get("Namespace");
                    if (namespaceValue != null)
                    {
                        String namespaceInstance;
                        namespaceInstance = namespaceValue.getTextValue();
                        metricSettingInstance.setNamespace(namespaceInstance);
                    }
                    
                    JsonNode valueValue2 = valueValue.get("Value");
                    if (valueValue2 != null)
                    {
                        String typeName = valueValue2.get("odata.type").getTextValue();
                        if (typeName == "Microsoft.WindowsAzure.Management.Monitoring.Metrics.Models.AvailabilityMetricSettingValue")
                        {
                            AvailabilityMetricSettingValue availabilityMetricSettingValueInstance = new AvailabilityMetricSettingValue();
                            
                            ArrayNode availableLocationsArray = ((ArrayNode)valueValue2.get("AvailableLocations"));
                            if (availableLocationsArray != null)
                            {
                                for (JsonNode availableLocationsValue : availableLocationsArray)
                                {
                                    NameConfig nameConfigInstance = new NameConfig();
                                    availabilityMetricSettingValueInstance.getAvailableLocations().add(nameConfigInstance);
                                    
                                    JsonNode nameValue = availableLocationsValue.get("Name");
                                    if (nameValue != null)
                                    {
                                        String nameInstance;
                                        nameInstance = nameValue.getTextValue();
                                        nameConfigInstance.setName(nameInstance);
                                    }
                                    
                                    JsonNode displayNameValue = availableLocationsValue.get("DisplayName");
                                    if (displayNameValue != null)
                                    {
                                        String displayNameInstance;
                                        displayNameInstance = displayNameValue.getTextValue();
                                        nameConfigInstance.setDisplayName(displayNameInstance);
                                    }
                                }
                            }
                            
                            ArrayNode endpointsArray = ((ArrayNode)valueValue2.get("Endpoints"));
                            if (endpointsArray != null)
                            {
                                for (JsonNode endpointsValue : endpointsArray)
                                {
                                    EndpointConfig endpointConfigInstance = new EndpointConfig();
                                    availabilityMetricSettingValueInstance.getEndpoints().add(endpointConfigInstance);
                                    
                                    JsonNode configIdValue = endpointsValue.get("ConfigId");
                                    if (configIdValue != null)
                                    {
                                        String configIdInstance;
                                        configIdInstance = configIdValue.getTextValue();
                                        endpointConfigInstance.setConfigId(configIdInstance);
                                    }
                                    
                                    JsonNode nameValue2 = endpointsValue.get("Name");
                                    if (nameValue2 != null)
                                    {
                                        String nameInstance2;
                                        nameInstance2 = nameValue2.getTextValue();
                                        endpointConfigInstance.setName(nameInstance2);
                                    }
                                    
                                    JsonNode locationValue = endpointsValue.get("Location");
                                    if (locationValue != null)
                                    {
                                        String locationInstance;
                                        locationInstance = locationValue.getTextValue();
                                        endpointConfigInstance.setLocation(locationInstance);
                                    }
                                    
                                    JsonNode urlValue = endpointsValue.get("Url");
                                    if (urlValue != null)
                                    {
                                        URI urlInstance;
                                        urlInstance = new URI(urlValue.getTextValue());
                                        endpointConfigInstance.setUrl(urlInstance);
                                    }
                                }
                            }
                            metricSettingInstance.setValue(availabilityMetricSettingValueInstance);
                        }
                    }
                }
            }
        }
        
        result.setStatusCode(statusCode);
        if (httpResponse.getHeaders("x-ms-request-id").length > 0)
        {
            result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
        }
        
        if (shouldTrace)
        {
            CloudTracing.exit(invocationId, result);
        }
        return result;
    }
}
