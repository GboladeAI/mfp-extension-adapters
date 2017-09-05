/*
 *  IBM Confidential OCO Source Materials
 *                                                                 
 *  5725-I43 Copyright IBM Corp. 2011, 2017
 *                                                                   
 *  The source code for this program is not published or otherwise
 *  divested of its trade secrets, irrespective of what has
 *  been deposited with the U.S. Copyright Office.
 *                   
 */


/*
 * Discovery
 * The IBM Watson&trade; Discovery Service is a cognitive search and content analytics engine that you can add to applications to identify patterns, trends and actionable insights to drive better decision-making. Securely unify structured and unstructured data with pre-enriched content, and use a simplified query language to eliminate the need for manual filtering of results. 
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.ibm.mfp.adapters.sample.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.mfp.adapters.sample.model.Field;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/*
 *  IBM Confidential OCO Source Materials
 *                                                                 
 *  5725-I43 Copyright IBM Corp. 2011, 2017
 *                                                                   
 *  The source code for this program is not published or otherwise
 *  divested of its trade secrets, irrespective of what has
 *  been deposited with the U.S. Copyright Office.
 *                   
 */


/**
 * The list of fetched fields.  The fields are returned using a fully-qualified name format, however, the format differs slightly from that used by the query operations. Specifically:      * fields which contain nested JSON objects are assigned a type of \&quot;nested\&quot;.      * fields which belong to a nested object are prefixed with &#x60;.properties&#x60; (e.g., &#x60;warnings.properties.severity&#x60; means that the &#x60;warnings&#x60; object has a property called &#x60;severity&#x60;).      * fields returned from the News collection are prefixed with &#x60;v[N]-fullnews-t3-[YEAR].mappings&#x60; (e.g., &#x60;v5-fullnews-t3-2016.mappings.text.properties.author&#x60;).
 */
@ApiModel(description = "The list of fetched fields.  The fields are returned using a fully-qualified name format, however, the format differs slightly from that used by the query operations. Specifically:      * fields which contain nested JSON objects are assigned a type of \"nested\".      * fields which belong to a nested object are prefixed with `.properties` (e.g., `warnings.properties.severity` means that the `warnings` object has a property called `severity`).      * fields returned from the News collection are prefixed with `v[N]-fullnews-t3-[YEAR].mappings` (e.g., `v5-fullnews-t3-2016.mappings.text.properties.author`).")
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-04T17:22:26.527+05:30")
public class ListCollectionFieldsResponse   {
  @JsonProperty("fields")
  private List<Field> fields = null;

  public ListCollectionFieldsResponse fields(List<Field> fields) {
    this.fields = fields;
    return this;
  }

  public ListCollectionFieldsResponse addFieldsItem(Field fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<Field>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

   /**
   * Get fields
   * @return fields
  **/
  @JsonProperty("fields")
  @ApiModelProperty(value = "")
  public List<Field> getFields() {
    return fields;
  }

  public void setFields(List<Field> fields) {
    this.fields = fields;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListCollectionFieldsResponse listCollectionFieldsResponse = (ListCollectionFieldsResponse) o;
    return Objects.equals(this.fields, listCollectionFieldsResponse.fields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fields);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListCollectionFieldsResponse {\n");
    
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

