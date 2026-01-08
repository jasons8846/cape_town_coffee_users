package com.jasons.cptcoffeeusers.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.jasons.cptcoffeeusers.model.Company;
import com.jasons.cptcoffeeusers.model.JsonNullableObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GetAllCompaniesResponseWrapper
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-08T05:21:18.282025300+02:00[Africa/Johannesburg]", comments = "Generator version: 7.4.0")
public class GetAllCompaniesResponseWrapper {

  @Valid
  private List<@Valid Company> data;

  private JsonNullableObject error;

  public GetAllCompaniesResponseWrapper data(List<@Valid Company> data) {
    this.data = data;
    return this;
  }

  public GetAllCompaniesResponseWrapper addDataItem(Company dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("data")
  public List<@Valid Company> getData() {
    return data;
  }

  public void setData(List<@Valid Company> data) {
    this.data = data;
  }

  public GetAllCompaniesResponseWrapper error(JsonNullableObject error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  */
  @Valid 
  @Schema(name = "error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("error")
  public JsonNullableObject getError() {
    return error;
  }

  public void setError(JsonNullableObject error) {
    this.error = error;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAllCompaniesResponseWrapper getAllCompaniesResponseWrapper = (GetAllCompaniesResponseWrapper) o;
    return Objects.equals(this.data, getAllCompaniesResponseWrapper.data) &&
        Objects.equals(this.error, getAllCompaniesResponseWrapper.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAllCompaniesResponseWrapper {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

