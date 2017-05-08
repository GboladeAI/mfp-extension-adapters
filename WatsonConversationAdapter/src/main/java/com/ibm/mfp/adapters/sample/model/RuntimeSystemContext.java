package com.ibm.mfp.adapters.sample.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * For internal use only.
 **/

@ApiModel(description = "For internal use only.")
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-05-08T13:53:48.254+05:30")
public class RuntimeSystemContext   {
  
  private Object runtimeSystemContext = null;

  /**
   **/
  public RuntimeSystemContext runtimeSystemContext(Object runtimeSystemContext) {
    this.runtimeSystemContext = runtimeSystemContext;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("RuntimeSystemContext")
  public Object getRuntimeSystemContext() {
    return runtimeSystemContext;
  }
  public void setRuntimeSystemContext(Object runtimeSystemContext) {
    this.runtimeSystemContext = runtimeSystemContext;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RuntimeSystemContext runtimeSystemContext = (RuntimeSystemContext) o;
    return Objects.equals(runtimeSystemContext, runtimeSystemContext.runtimeSystemContext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(runtimeSystemContext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuntimeSystemContext {\n");
    
    sb.append("    runtimeSystemContext: ").append(toIndentedString(runtimeSystemContext)).append("\n");
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

