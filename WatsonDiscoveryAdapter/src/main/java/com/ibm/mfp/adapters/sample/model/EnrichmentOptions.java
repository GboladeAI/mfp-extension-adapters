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
import com.fasterxml.jackson.annotation.JsonValue;
import com.ibm.mfp.adapters.sample.model.LanguageEnrichmentOptions;
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
 * options which are specific to a particular enrichment
 */
@ApiModel(description = "options which are specific to a particular enrichment")
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-04T17:22:26.527+05:30")
public class EnrichmentOptions   {
  @JsonProperty("extract")
  private String extract = "entity,keyword,concept,taxonomy";

  @JsonProperty("sentiment")
  private Boolean sentiment = false;

  @JsonProperty("quotations")
  private Boolean quotations = false;

  @JsonProperty("showSourceText")
  private Boolean showSourceText = false;

  @JsonProperty("hierarchicalTypedRelations")
  private Boolean hierarchicalTypedRelations = false;

  @JsonProperty("model")
  private String model = null;

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
   * If provided, then do not attempt to detect the language of the input document. Instead, assume the language is the one specified in this field.  You can set this property to work around `unsupported-text-language` errors.  Supported languages include English, German, French, Italian, Portuguese, Russian, Spanish and Swedish. Supported language codes are the ISO-639-1, ISO-639-2, ISO-639-3, and the plain english name of the language (e.g. \"russian\").
   */
  public enum LanguageEnum {
    ENGLISH("english"),
    
    GERMAN("german"),
    
    FRENCH("french"),
    
    ITALIAN("italian"),
    
    PORTUGUESE("portuguese"),
    
    RUSSIAN("russian"),
    
    SPANISH("spanish"),
    
    SWEDISH("swedish"),
    
    EN("en"),
    
    ENG("eng"),
    
    DE("de"),
    
    GER("ger"),
    
    DEU("deu"),
    
    FR("fr"),
    
    FRE("fre"),
    
    FRA("fra"),
    
    IT("it"),
    
    ITA("ita"),
    
    PT("pt"),
    
    POR("por"),
    
    RU("ru"),
    
    RUS("rus"),
    
    ES("es"),
    
    SPA("spa"),
    
    SV("sv"),
    
    SWE("swe");

    private String value;

    LanguageEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LanguageEnum fromValue(String text) {
      for (LanguageEnum b : LanguageEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("language")
  private LanguageEnum language = null;

  public EnrichmentOptions extract(String extract) {
    this.extract = extract;
    return this;
  }

   /**
   * A comma sepeated list of analyses that should be applied when using the `alchemy_language` enrichment. See the the service documentation for details on each extract option.  Possible values include:    * entity   * keyword   * taxonomy   * concept   * relation   * doc-sentiment   * doc-emotion   * typed-rels
   * @return extract
  **/
  @JsonProperty("extract")
  @ApiModelProperty(value = "A comma sepeated list of analyses that should be applied when using the `alchemy_language` enrichment. See the the service documentation for details on each extract option.  Possible values include:    * entity   * keyword   * taxonomy   * concept   * relation   * doc-sentiment   * doc-emotion   * typed-rels")
  public String getExtract() {
    return extract;
  }

  public void setExtract(String extract) {
    this.extract = extract;
  }

  public EnrichmentOptions sentiment(Boolean sentiment) {
    this.sentiment = sentiment;
    return this;
  }

   /**
   * Get sentiment
   * @return sentiment
  **/
  @JsonProperty("sentiment")
  @ApiModelProperty(value = "")
  public Boolean getSentiment() {
    return sentiment;
  }

  public void setSentiment(Boolean sentiment) {
    this.sentiment = sentiment;
  }

  public EnrichmentOptions quotations(Boolean quotations) {
    this.quotations = quotations;
    return this;
  }

   /**
   * Get quotations
   * @return quotations
  **/
  @JsonProperty("quotations")
  @ApiModelProperty(value = "")
  public Boolean getQuotations() {
    return quotations;
  }

  public void setQuotations(Boolean quotations) {
    this.quotations = quotations;
  }

  public EnrichmentOptions showSourceText(Boolean showSourceText) {
    this.showSourceText = showSourceText;
    return this;
  }

   /**
   * Get showSourceText
   * @return showSourceText
  **/
  @JsonProperty("showSourceText")
  @ApiModelProperty(value = "")
  public Boolean getShowSourceText() {
    return showSourceText;
  }

  public void setShowSourceText(Boolean showSourceText) {
    this.showSourceText = showSourceText;
  }

  public EnrichmentOptions hierarchicalTypedRelations(Boolean hierarchicalTypedRelations) {
    this.hierarchicalTypedRelations = hierarchicalTypedRelations;
    return this;
  }

   /**
   * Get hierarchicalTypedRelations
   * @return hierarchicalTypedRelations
  **/
  @JsonProperty("hierarchicalTypedRelations")
  @ApiModelProperty(value = "")
  public Boolean getHierarchicalTypedRelations() {
    return hierarchicalTypedRelations;
  }

  public void setHierarchicalTypedRelations(Boolean hierarchicalTypedRelations) {
    this.hierarchicalTypedRelations = hierarchicalTypedRelations;
  }

  public EnrichmentOptions model(String model) {
    this.model = model;
    return this;
  }

   /**
   * Required when using the `typed-rel` extract option. Should be set to the ID of a previously published custom Watson Knowledge Studio model.
   * @return model
  **/
  @JsonProperty("model")
  @ApiModelProperty(value = "Required when using the `typed-rel` extract option. Should be set to the ID of a previously published custom Watson Knowledge Studio model.")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public EnrichmentOptions language(LanguageEnum language) {
    this.language = language;
    return this;
  }

   /**
   * If provided, then do not attempt to detect the language of the input document. Instead, assume the language is the one specified in this field.  You can set this property to work around `unsupported-text-language` errors.  Supported languages include English, German, French, Italian, Portuguese, Russian, Spanish and Swedish. Supported language codes are the ISO-639-1, ISO-639-2, ISO-639-3, and the plain english name of the language (e.g. \"russian\").
   * @return language
  **/
  @JsonProperty("language")
  @ApiModelProperty(value = "If provided, then do not attempt to detect the language of the input document. Instead, assume the language is the one specified in this field.  You can set this property to work around `unsupported-text-language` errors.  Supported languages include English, German, French, Italian, Portuguese, Russian, Spanish and Swedish. Supported language codes are the ISO-639-1, ISO-639-2, ISO-639-3, and the plain english name of the language (e.g. \"russian\").")
  public LanguageEnum getLanguage() {
    return language;
  }

  public void setLanguage(LanguageEnum language) {
    this.language = language;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnrichmentOptions enrichmentOptions = (EnrichmentOptions) o;
    return Objects.equals(this.extract, enrichmentOptions.extract) &&
        Objects.equals(this.sentiment, enrichmentOptions.sentiment) &&
        Objects.equals(this.quotations, enrichmentOptions.quotations) &&
        Objects.equals(this.showSourceText, enrichmentOptions.showSourceText) &&
        Objects.equals(this.hierarchicalTypedRelations, enrichmentOptions.hierarchicalTypedRelations) &&
        Objects.equals(this.model, enrichmentOptions.model) &&
        Objects.equals(this.language, enrichmentOptions.language);
  }

  @Override
  public int hashCode() {
    return Objects.hash(extract, sentiment, quotations, showSourceText, hierarchicalTypedRelations, model, language);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnrichmentOptions {\n");
    
    sb.append("    extract: ").append(toIndentedString(extract)).append("\n");
    sb.append("    sentiment: ").append(toIndentedString(sentiment)).append("\n");
    sb.append("    quotations: ").append(toIndentedString(quotations)).append("\n");
    sb.append("    showSourceText: ").append(toIndentedString(showSourceText)).append("\n");
    sb.append("    hierarchicalTypedRelations: ").append(toIndentedString(hierarchicalTypedRelations)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
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

