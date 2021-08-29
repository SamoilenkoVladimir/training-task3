package domain;

public class Deposit {
	private String id;
	private String name;
	private String country;
	private String type;
	private String depositorName;
	private String depositorSurname;
	private Long accountId;
	private Long amountDeposit;
	private Integer profitability;
	private Integer timeConstraints;
	public Deposit() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDepositorName() {
		return depositorName;
	}
	public void setDepositorName(String depositorName) {
		this.depositorName = depositorName;
	}
	public String getDepositorSurname() {
		return depositorSurname;
	}
	public void setDepositorSurname(String depositorSurname) {
		this.depositorSurname = depositorSurname;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getAmountDeposit() {
		return amountDeposit;
	}
	public void setAmountDeposit(Long amountDeposit) {
		this.amountDeposit = amountDeposit;
	}
	public Integer getProfitability() {
		return profitability;
	}
	public void setProfitability(Integer profitability) {
		this.profitability = profitability;
	}
	public Integer getTimeConstraints() {
		return timeConstraints;
	}
	public void setTimeConstraints(Integer timeConstraints) {
		this.timeConstraints = timeConstraints;
	}
	
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Deposit [id=" + id + ", name=" + name + ", country=" + country + ", type=" + type + ", depositorName="
				+ depositorName + ", depositorSurname=" + depositorSurname + ", accountId=" + accountId
				+ ", amountDeposit=" + amountDeposit + ", profitability=" + profitability + ", timeConstraints="
				+ timeConstraints + "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}

