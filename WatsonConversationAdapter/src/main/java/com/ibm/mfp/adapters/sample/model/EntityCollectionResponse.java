package com.ibm.mfp.adapters.sample.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.mfp.adapters.sample.model.EntityExportResponse;
import com.ibm.mfp.adapters.sample.model.PaginationResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * An array of entities.
 **/

@ApiModel(description = "An array of entities.")
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-05-08T13:53:48.254+05:30")
public class EntityCollectionResponse   {
  
  private List<EntityExportResponse> entities = new ArrayList<EntityExportResponse>();
  private PaginationResponse pagination = null;

  /**
   **/
  public EntityCollectionResponse entities(List<EntityExportResponse> entities) {
    this.entities = entities;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("entities")
  public List<EntityExportResponse> getEntities() {
    return entities;
  }
  public void setEntities(List<EntityExportResponse> entities) {
    this.entities = entities;
  }

  /**
   **/
  public EntityCollectionResponse pagination(PaginationResponse pagination) {
    this.pagination = pagination;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("pagination")
  public PaginationResponse getPagination() {
    return pagination;
  }
  public void setPagination(PaginationResponse pagination) {
    this.pagination = pagination;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityCollectionResponse entityCollectionResponse = (EntityCollectionResponse) o;
    return Objects.equals(entities, entityCollectionResponse.entities) &&
        Objects.equals(pagination, entityCollectionResponse.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entities, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityCollectionResponse {\n");
    
    sb.append("    entities: ").append(toIndentedString(entities)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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
