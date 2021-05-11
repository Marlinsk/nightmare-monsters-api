package src.code.mstr.entidade;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "")
public class Monster {
    
	private String id;
	private String nome;
	private String nomeOriginal;
	private String tipo;
	private String descricao;
	private String caracteristica; 
	private String mundo;
	private String habitat;
	private String dieta;
	private String escalaPerigo;
	private String fraqueza;
	
	public Monster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monster(String nome, String nomeOriginal, String tipo, String descricao, String caracteristica, String mundo, String habitat, String dieta, String escalaPerigo, String fraqueza) {
		super();
		
		this.nome = nome;
		this.nomeOriginal = nomeOriginal;
		this.tipo = tipo;
		this.descricao = descricao;
		this.caracteristica = caracteristica;
		this.mundo = mundo;
		this.habitat = habitat;
		this.dieta = dieta;
		this.escalaPerigo = escalaPerigo;
		this.fraqueza = fraqueza;
	}
    
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
	@DynamoDBAttribute
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@DynamoDBAttribute
	public String getNomeOriginal() {
		return nomeOriginal;
	}

	public void setNomeOriginal(String nomeOriginal) {
		this.nomeOriginal = nomeOriginal;
	}

	@DynamoDBAttribute
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@DynamoDBAttribute
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@DynamoDBAttribute
	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	@DynamoDBAttribute
	public String getMundo() {
		return mundo;
	}

	public void setMundo(String mundo) {
		this.mundo = mundo;
	}

	@DynamoDBAttribute
	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	@DynamoDBAttribute
	public String getDieta() {
		return dieta;
	}

	public void setDieta(String dieta) {
		this.dieta = dieta;
	}

	@DynamoDBAttribute
	public String getEscalaPerigo() {
		return escalaPerigo;
	}

	public void setEscalaPerigo(String escalaPerigo) {
		this.escalaPerigo = escalaPerigo;
	}

	@DynamoDBAttribute
	public String getFraqueza() {
		return fraqueza;
	}
    
	public void setFraqueza(String fraqueza) {
		this.fraqueza = fraqueza;
	}
     
	@Override
	public String toString() {
		return "Dados do monstro {" + "ID: " + id + ", Nome: " + nome + ", Nome original: " + nomeOriginal + ", Tipo: " + tipo
				+ ", Descrição: " + descricao + ", Característica: " + caracteristica + ", Mundo: " + mundo + ", Habitat: "
				+ habitat + ", Dieta:" + dieta + ", Escala de Perigo: " + escalaPerigo + ", Fraqueza: " + fraqueza + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caracteristica == null) ? 0 : caracteristica.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dieta == null) ? 0 : dieta.hashCode());
		result = prime * result + ((escalaPerigo == null) ? 0 : escalaPerigo.hashCode());
		result = prime * result + ((fraqueza == null) ? 0 : fraqueza.hashCode());
		result = prime * result + ((habitat == null) ? 0 : habitat.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mundo == null) ? 0 : mundo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeOriginal == null) ? 0 : nomeOriginal.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monster other = (Monster) obj;
		if (caracteristica == null) {
			if (other.caracteristica != null)
				return false;
		} else if (!caracteristica.equals(other.caracteristica))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dieta == null) {
			if (other.dieta != null)
				return false;
		} else if (!dieta.equals(other.dieta))
			return false;
		if (escalaPerigo == null) {
			if (other.escalaPerigo != null)
				return false;
		} else if (!escalaPerigo.equals(other.escalaPerigo))
			return false;
		if (fraqueza == null) {
			if (other.fraqueza != null)
				return false;
		} else if (!fraqueza.equals(other.fraqueza))
			return false;
		if (habitat == null) {
			if (other.habitat != null)
				return false;
		} else if (!habitat.equals(other.habitat))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mundo == null) {
			if (other.mundo != null)
				return false;
		} else if (!mundo.equals(other.mundo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeOriginal == null) {
			if (other.nomeOriginal != null)
				return false;
		} else if (!nomeOriginal.equals(other.nomeOriginal))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
}