package br.edu.ifpb.fcgp.academico.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.fcgp.academico.model.Disciplina;



@FacesConverter(value = "genericDis", forClass = Disciplina.class)
public class ConverterDisciplina implements Converter, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
		if(value != null && !value.isEmpty()) {
			return(Disciplina) comp.getAttributes().get(value);
		}
		

        return null;
    }
	
public String getAsString(FacesContext ctx, UIComponent comp, Object obj) {
    	
    	if(obj instanceof Disciplina) {
    		Disciplina entity = (Disciplina) obj;
    		if(entity instanceof Disciplina && entity.getId() !=null) {
    			comp.getAttributes().put(entity.getId().toString(), entity);
    			return entity.getId().toString();
    		}
    		
    	}
    	
        return   "";
    }

}
