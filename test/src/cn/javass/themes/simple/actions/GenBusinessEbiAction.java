package cn.javass.themes.simple.actions;

import cn.javass.xgen.genconf.vo.ModuleConfModel;
import cn.javass.xgen.geninvocation.BaseGenAction;
import cn.javass.xgen.geninvocation.decorator.GenComponent;

public class GenBusinessEbiAction extends BaseGenAction {
	@Override
	public Object executeDerectors(ModuleConfModel moduleConf, Object obj,
			GenComponent gc) {
		//这里的"GenBusinessEbi"和theme配置中的GenType的id对应
		return gc.operation(moduleConf, "GenBusinessEbi", obj);
	}

	@Override
	public Object initObject() {
		return "";
	}

	@Override
	public Object execute(ModuleConfModel moduleConf, Object obj) {
		return obj;
	}
	
	public  GenComponent beforeAction(ModuleConfModel moduleConf){
		return super.defaultBeforeAction(moduleConf);
	}
}