package cn.javass.themes.mytheme.visitors;

import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitor.TemplateElement;
import cn.javass.xgen.template.visitor.Visitor;

public class VoPropertyGetterSetter implements Visitor {

	@Override
	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		
		String [] voFields =  moduleConf.getMapExtends().get("voFields").getValues();		
		String [] voFieldsTypes = moduleConf.getMapExtends().get("voFieldsType").getValues();
		
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;i<voFields.length;i++){
			//setter
			buffer.append("public void set"+voFields[i].substring(0,1).toUpperCase()
					+voFields[i].substring(1)+"("+voFieldsTypes[i]+" obj){\n\t\t");
			buffer.append("this."+voFields[i]+" = obj;\n\t");
			buffer.append("}\n\t");
			//getter
			buffer.append("public "+voFieldsTypes[i]+" get"+voFields[i].substring(0,1).toUpperCase()
					+voFields[i].substring(1)+"(){\n\t\t");
			buffer.append("return this."+voFields[i]+";\n\t");
			buffer.append("}\n\t");
			
			buffer.append("\n\t");
		}
		
		return buffer.toString();
	}

}