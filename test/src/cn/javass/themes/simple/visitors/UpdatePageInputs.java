package cn.javass.themes.simple.visitors;

import cn.javass.xgen.genconf.GenConfFactory;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitor.TemplateElement;
import cn.javass.xgen.template.visitor.Visitor;

public class UpdatePageInputs implements Visitor {

	@Override
	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		
		String [] colunName_CN = moduleConf.getMapExtends().get( "colunName_CN").getValues();	
		String [] voFields = moduleConf.getMapExtends().get( "voFields").getValues();	
		
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;i<colunName_CN.length;i++){
			String action_modelName =moduleConf.getMapExtends().get( "action_modelName").getValue();
		    buffer.append("<tr>\n\t\t");
			buffer.append("<td>"+colunName_CN[i]+"</td>\n\t");
			buffer.append("<td><input type=\"text\" name=\""+action_modelName+"."+voFields[i]+"\""
					+"  value='<s:property value=\""+action_modelName+"."+voFields[i]+"\"/>'  class='input'/></td>\n\t");
			buffer.append("</tr>\n\t");
		}
		return buffer.toString();
	}

}
