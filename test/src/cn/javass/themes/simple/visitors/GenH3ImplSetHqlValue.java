package cn.javass.themes.simple.visitors;

import cn.javass.xgen.genconf.GenConfFactory;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitor.TemplateElement;
import cn.javass.xgen.template.visitor.Visitor;

public class GenH3ImplSetHqlValue implements Visitor {

	@Override
	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		
		String [] voFields = moduleConf.getMapExtends().get("voFields").getValues();	
		String [] voFieldsTypes = moduleConf.getMapExtends().get("voFieldsTypes").getValues();
		String [] queryConditions = moduleConf.getMapExtends().get("queryConditions").getValues();
		
		String s1 = genH3ImplSetHqlValue(moduleConf,voFields,voFieldsTypes,queryConditions);
		
		String [] qmVoFields = moduleConf.getMapExtends().get( "qmVoFields").getValues();	
		String [] qmVoFieldsTypes = moduleConf.getMapExtends().get("qmVoFieldsTypes").getValues();
		String [] qmQueryConditions = moduleConf.getMapExtends().get("qmQueryConditions").getValues();
		
		String s2 = genH3ImplSetHqlValue(moduleConf,qmVoFields,qmVoFieldsTypes,qmQueryConditions);
		
		return s1+s2;
	}
	private static String genH3ImplSetHqlValue(ModuleConfModel moduleConf,String fields[],String fieldTypes[],String opeType[]){
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;i < fields.length;i++){
			if(fields[i]==null || fields[i].trim().length()==0){
				break;
			}
			String superName = fields[i].substring(0,1).toUpperCase()
			+fields[i].substring(1);
			if(fieldTypes[i].equals("String")){
				buffer.append("if(qm.get"+superName+"()!=null && qm.get"+superName+"().trim().length()>0){\n\t\t\t");
				if(opeType[i].equals("like")){
					buffer.append("q.setString(\""+fields[i]+"\", \"%\"+qm.get"+superName+"()+\"%\");\n\t\t");
				}else{
					buffer.append("q.setString(\""+fields[i]+"\", qm.get"+superName+"());\n\t\t");
				}
				buffer.append("}\n\n\t\t");
			}else if(fieldTypes[i].equals("int") || fieldTypes[i].equals("long") || fieldTypes[i].equals("double") || fieldTypes[i].equals("float")){
				buffer.append("if(qm.get"+superName+"()>0){\n\t\t\t");
				buffer.append("q.setParameter(\""+fields[i]+"\", qm.get"+superName+"());\n\t\t");
				buffer.append("}\n\n\t\t");
			}			
		}		
		return buffer.toString();
	}
	

}