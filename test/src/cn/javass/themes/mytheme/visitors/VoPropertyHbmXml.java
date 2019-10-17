package cn.javass.themes.mytheme.visitors;

import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitor.TemplateElement;
import cn.javass.xgen.template.visitor.Visitor;

public class VoPropertyHbmXml implements Visitor {

	@Override
	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		
		String [] voFields =  moduleConf.getMapExtends().get("voFields").getValues();		
		
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;i<voFields.length;i++){
			buffer.append("<property name=\""+voFields[i]+"\" />\n\t");
		}
		return buffer.toString();
	}

}