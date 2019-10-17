package cn.javass.themes.mytheme.actions;

import cn.javass.themes.mytheme.decorators.MyDecorator;
import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.geninvocation.BaseGenAction;
import cn.javass.xgen.geninvocation.decorator.GenComponent;

public class VoAction extends BaseGenAction{

	@Override
	public Object execute(ModuleConfModel arg0, Object obj) {
		return obj;
	}

	@Override
	public Object executeDerectors(ModuleConfModel moduleConf, Object obj,
			GenComponent gc) {
		
		GenComponent myGc = new MyDecorator(gc);
		
		return myGc.operation(moduleConf, "GenVo", obj);
	}

	@Override
	public Object initObject() {
		return "";
	}
	
	public  GenComponent beforeAction(ModuleConfModel moduleConf){
		return super.defaultBeforeAction(moduleConf);
	}
}
