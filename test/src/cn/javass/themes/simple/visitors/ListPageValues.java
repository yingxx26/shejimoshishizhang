package cn.javass.themes.simple.visitors;

import cn.javass.xgen.genconf.GenConfFactory;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitor.TemplateElement;
import cn.javass.xgen.template.visitor.Visitor;

public class ListPageValues implements Visitor {

	@Override
	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		
		String [] voFields = moduleConf.getMapExtends().get("voFields").getValues();	
		StringBuffer buffer = new StringBuffer("");
		for(String s : voFields){
			buffer.append("<td align=\"center\"><s:property value=\""+s+"\"/></td>\n\t");
		}
		return buffer.toString();
	}

}