package com.gots.cg.beans.schema.olp;

import lombok.Data;

import java.util.Map;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/21 12:43
 */
@Data
public class OLP_Base {

//  long id;

  String type;

  Map<String, Object> properties;
}
