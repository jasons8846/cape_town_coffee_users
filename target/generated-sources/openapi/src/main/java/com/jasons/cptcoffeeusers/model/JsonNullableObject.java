package com.jasons.cptcoffeeusers.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * JsonNullableObject
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-09T15:53:38.779259100+02:00[Africa/Johannesburg]", comments = "Generator version: 7.4.0")
public class JsonNullableObject {

  private Boolean present;

  public JsonNullableObject present(Boolean present) {
    this.present = present;
    return this;
  }

  /**
   * Get present
   * @return present
  */
  
  @Schema(name = "present", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("present")
  public Boolean getPresent() {
    return present;
  }

  public void setPresent(Boolean present) {
    this.present = present;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonNullableObject jsonNullableObject = (JsonNullableObject) o;
    return Objects.equals(this.present, jsonNullableObject.present);
  }

  @Override
  public int hashCode() {
    return Objects.hash(present);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonNullableObject {\n");
    sb.append("    present: ").append(toIndentedString(present)).append("\n");
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

