package metricasCD;

import java.util.ArrayList;


public class Rule {
	//os thresholds t�m que ser passados de string para ints
	
		private String name;
		private String tipo;
		private ArrayList<RuleObject> rule_info = new ArrayList<RuleObject>();
		
		public Rule(String name, String tipo) { //Rules � criada na GUI antes de ser pedida informa��o ao user, vai sendo adicionada por partes
			this.name = name;
			this.tipo = tipo;
			this.rule_info = new ArrayList<RuleObject>();
		} 
		
		public void set_info(String info, String label) { //quando o user mete um novo elemento � adicionado ao array
			RuleObject object = new RuleObject(info, label);
			this.rule_info.add(object);
		}
		
		public void edit_thresholds(RuleObject new_info, int id) { //quando o objecto para ser editado � seleccionado tem que vir com o id da posi��o do threshold
			if (new_info.label.equals("threshold")) {
				rule_info.set(id, new_info);
			}
		}
}
