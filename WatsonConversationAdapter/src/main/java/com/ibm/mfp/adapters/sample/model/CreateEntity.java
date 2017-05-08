package com.ibm.mfp.adapters.sample.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.mfp.adapters.sample.model.CreateValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;





@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-05-08T13:53:48.254+05:30")
public class CreateEntity   {
  
  private String entity = null;
  private String description = null;
  private Object metadata = null;
  private List<CreateValue> values = new ArrayList<CreateValue>();

  /**
   * The name of the entity.
   **/
  public CreateEntity entity(String entity) {
    this.entity = entity;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The name of the entity.")
  @JsonProperty("entity")
  public String getEntity() {
    return entity;
  }
  public void setEntity(String entity) {
    this.entity = entity;
  }

  /**
   * The description of the entity.
   **/
  public CreateEntity description(String description) {
    this.description = description;
    return this;
  }

  
  @ApiModelProperty(value = "The description of the entity.")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Any metadata related to the value.
   **/
  public CreateEntity metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @ApiModelProperty(value = "Any metadata related to the value.")
  @JsonProperty("metadata")
  public Object getMetadata() {
    return metadata;
  }
  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  /**
   * An array of entity values.
   **/
  public CreateEntity values(List<CreateValue> values) {
    this.values = values;
    return this;
  }

  
  @ApiModelProperty(value = "An array of entity values.")
  @JsonProperty("values")
  public List<CreateValue> getValues() {
    return values;
  }
  public void setValues(List<CreateValue> values) {
    this.values = values;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateEntity createEntity = (CreateEntity) o;
    return Objects.equals(entity, createEntity.entity) &&
        Objects.equals(description, createEntity.description) &&
        Objects.equals(metadata, createEntity.metadata) &&
        Objects.equals(values, createEntity.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entity, description, metadata, values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateEntity {\n");
    
    sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
