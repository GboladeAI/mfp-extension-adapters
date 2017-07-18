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
 * OpenWhisk REST API
 * API for OpenWhisk
 *
 * OpenAPI spec version: 0.1.0
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
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
 * definition of the action, such as javascript code or the name of a container
 */
@ApiModel(description = "definition of the action, such as javascript code or the name of a container")
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-07-03T19:13:35.134+05:30")
public class ActionExec   {
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
   * the type of action
   */
  public enum KindEnum {
    NODEJS("nodejs"),
    
    NODEJS_6("nodejs:6"),
    
    NODEJS_DEFAULT("nodejs:default"),
    
    PYTHON("python"),
    
    SWIFT("swift"),
    
    SWIFT_3("swift:3"),
    
    SWIFT_DEFAULT("swift:default"),
    
    JAVA("java"),
    
    BLACKBOX("blackbox");

    private String value;

    KindEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static KindEnum fromValue(String text) {
      for (KindEnum b : KindEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("kind")
  private KindEnum kind = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("init")
  private String init = null;

  public ActionExec kind(KindEnum kind) {
    this.kind = kind;
    return this;
  }

   /**
   * the type of action
   * @return kind
  **/
  @JsonProperty("kind")
  @ApiModelProperty(required = true, value = "the type of action")
  @NotNull
  public KindEnum getKind() {
    return kind;
  }

  public void setKind(KindEnum kind) {
    this.kind = kind;
  }

  public ActionExec code(String code) {
    this.code = code;
    return this;
  }

   /**
   * The code to execute when kind is not 'blackbox'
   * @return code
  **/
  @JsonProperty("code")
  @ApiModelProperty(value = "The code to execute when kind is not 'blackbox'")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ActionExec image(String image) {
    this.image = image;
    return this;
  }

   /**
   * container image name when kind is 'blackbox'
   * @return image
  **/
  @JsonProperty("image")
  @ApiModelProperty(value = "container image name when kind is 'blackbox'")
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public ActionExec init(String init) {
    this.init = init;
    return this;
  }

   /**
   * optional zipfile reference when code kind is 'nodejs'
   * @return init
  **/
  @JsonProperty("init")
  @ApiModelProperty(value = "optional zipfile reference when code kind is 'nodejs'")
  public String getInit() {
    return init;
  }

  public void setInit(String init) {
    this.init = init;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActionExec actionExec = (ActionExec) o;
    return Objects.equals(this.kind, actionExec.kind) &&
        Objects.equals(this.code, actionExec.code) &&
        Objects.equals(this.image, actionExec.image) &&
        Objects.equals(this.init, actionExec.init);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, code, image, init);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActionExec {\n");
    
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    init: ").append(toIndentedString(init)).append("\n");
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
