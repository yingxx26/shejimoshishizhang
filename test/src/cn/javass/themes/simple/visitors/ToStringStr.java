package cn.javass.themes.simple.visitors;

import cn.javass.xgen.genconf.GenConfFactory;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitor.TemplateElement;
import cn.javass.xgen.template.visitor.Visitor;

public class ToStringStr implements Visitor {

	@Override
	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		
		String [] voFields = moduleConf.getMapExtends().get( "voFields").getValues();		
		
		StringBuffer buffer = new StringBuffer("StringBuffer buffer = new StringBuffer();\n");
		for(int i=0;i<voFields.length;i++){
			buffer.append("\t\tbuffer.append(\""+voFields[i]+"=\"+this."+voFields[i]+"+\",\");\n");
		}
		return buffer.toString();
	}

}