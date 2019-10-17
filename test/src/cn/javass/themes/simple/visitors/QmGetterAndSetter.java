package cn.javass.themes.simple.visitors;

import cn.javass.xgen.genconf.GenConfFactory;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitor.TemplateElement;
import cn.javass.xgen.template.visitor.Visitor;

public class QmGetterAndSetter implements Visitor {

	@Override
	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		
		return genGgetterAndSetter(moduleConf,"qmVoFields", "qmVoFieldsTypes");
	}
	private static String genGgetterAndSetter(ModuleConfModel moduleConf,String fieldsName,String fieldsTypesName) {
		String [] voFields =  moduleConf.getMapExtends().get( fieldsName).getValues();		
		String [] voFieldsTypes = moduleConf.getMapExtends().get( fieldsTypesName).getValues();
		
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;i<voFields.length;i++){
			if(voFields[i]==null || voFields[i].trim().length()==0){
				break;
			}
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