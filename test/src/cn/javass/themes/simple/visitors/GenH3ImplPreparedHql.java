package cn.javass.themes.simple.visitors;

import cn.javass.xgen.genconf.GenConfFactory;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.template.visitor.TemplateElement;
import cn.javass.xgen.template.visitor.Visitor;

public class GenH3ImplPreparedHql implements Visitor {

	@Override
	public Object visitTemplateElement(TemplateElement element) {
		ModuleConfModel moduleConf = element.getModuleConf();
		
		String [] voFields = moduleConf.getMapExtends().get("voFields").getValues();	
		String [] voFieldsTypes = moduleConf.getMapExtends().get("voFieldsTypes").getValues();
		String [] queryConditions = moduleConf.getMapExtends().get("queryConditions").getValues();
		
		String s1 = genH3ImplPreparedHql(moduleConf,voFields,voFieldsTypes,queryConditions,false);
		
		String [] qmVoFields = moduleConf.getMapExtends().get("qmVoFields").getValues();	
		String [] qmVoFieldsTypes = moduleConf.getMapExtends().get("qmVoFieldsTypes").getValues();
		String [] qmQueryConditions = moduleConf.getMapExtends().get("qmQueryConditions").getValues();
		
		String s2 = genH3ImplPreparedHql(moduleConf,qmVoFields,qmVoFieldsTypes,qmQueryConditions,true);
		
		return s1+s2;
	}
	private static String genH3ImplPreparedHql(ModuleConfModel moduleConf,String fields[],String fieldTypes[],String opeType[],boolean isQuery){
		StringBuffer buffer = new StringBuffer("");
		for(int i=0;i < fields.length;i++){
			if(fields[i]==null || fields[i].trim().length()==0){
				break;
			}
			String superName = fields[i].substring(0,1).toUpperCase()
			+fields[i].substring(1);
			if(fieldTypes[i].equals("String")){
				buffer.append("if(qm.get"+superName+"()!=null && qm.get"+superName+"().trim().length()>0){\n\t\t\t");
				if(isQuery){
					buffer.append("initHql += \" and o."+fields[i].substring(0,fields[i].length()-1)+" "+opeType[i]+" :"+fields[i]+"\";\n\t\t");
				}else{
					buffer.append("initHql += \" and o."+fields[i]+" "+opeType[i]+" :"+fields[i]+"\";\n\t\t");
				}
				buffer.append("}\n\n\t\t");
			}else if(fieldTypes[i].equals("int") || fieldTypes[i].equals("long") || fieldTypes[i].equals("double") || fieldTypes[i].equals("float")){
				buffer.append("if(qm.get"+superName+"()>0){\n\t\t\t");
				if(isQuery){
					buffer.append("initHql += \" and o."+fields[i].substring(0,fields[i].length()-1)+" "+opeType[i]+" :"+fields[i]+"\";\n\t\t");
				}else{
					buffer.append("initHql += \" and o."+fields[i]+" "+opeType[i]+" :"+fields[i]+"\";\n\t\t");
				}
				buffer.append("}\n\n\t\t");
			}			
		}		
		return buffer.toString();
	}

}