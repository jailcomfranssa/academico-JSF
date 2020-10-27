package br.edu.ifpb.fcgp.academico.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.fcgp.academico.model.Turma;

@FacesConverter(value = "genericTurma", forClass = Turma.class)
public class ConverterTurma implements Converter, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
		if(value != null && !value.isEmpty()) {
			return(Turma) comp.getAttributes().get(value);
		}
		

        return null;
    }

    public String getAsString(FacesContext ctx, UIComponent comp, Object obj) {
    	
    	if(obj instanceof Turma) {
    		Turma entity = (Turma) obj;
    		if(entity instanceof Turma && entity.getId() !=null) {
    			comp.getAttributes().put(entity.getId().toString(), entity);
    			return entity.getId().toString();
    		}
    		
    	}
    	
        return   "";
    }


}
