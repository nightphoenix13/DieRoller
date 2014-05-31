package DieRoller;

public class Character
{
	// class attributes
	static private int attackBonus,
					   baseAttack,
					   confirmBonus,
					   damageDice,
					   damageBonus,
					   critOn;
	static private String name;
	
	// constructor
	public Character(String n, int ab, int ba, int cb, int dd, int db, int co)
	{
		setCharacter(n, ab, ba, cb, dd, db, co);
	}
	
	// class set method
	private void setCharacter(String n, int ab, int ba, int cb, int dd, int db, int co) // setCharacter method start
	{
		setName(n);
		setAttackBonus(ab);
		setBaseAttack(ba);
		setConfirmBonus(cb);
		setDamageDice(dd);
		setDamageBonus(db);
		setCritOn(co);
	} // setCharacter method end
	
	// class set methods
	public void setName(String n) // name set method start
	{
		name = n;
	} // name set method end
	
	public void setAttackBonus(int ab) // attackBonus set method start
	{
		attackBonus = ab;
	} // attackBonus set method end
	
	public void setBaseAttack(int ba) // baseAttack set method start
	{
		baseAttack = ba;
	} // baseAttack set method end
	
	public void setConfirmBonus(int cb) // confirmBonus set method start
	{
		confirmBonus = cb;
	} // confirmBonus set method end
	
	public void setDamageDice(int dd) // damageDice set method start
	{
		damageDice = dd;
	} // damageDice set method end
	
	public void setDamageBonus(int db) // damageBonus set method start
	{
		damageBonus = db;
	} // damageBonus set method end
	
	public void setCritOn(int co) // critOn set method start
	{
		critOn = co;
	} // critOn set method end
	
	// class get methods
	public String getName() // name get method start
	{
		return name;
	} // name get method end
	
	public int getAttackbonus() // attackBonus get method start
	{
		return attackBonus;
	} // attackBonus get method end
	
	public int getBaseAttack() // baseAttack get method start
	{
		return baseAttack;
	} // baseAttack get method end
	
	public int getConfirmBonus() // confirmBonus get method start
	{
		return confirmBonus;
	} // confirmBonus get method end
	
	public int getDamageDice() // damageDice get method start
	{
		return damageDice;
	} // damageDice get method end
	
	public int getDamageBonus() // damageBonus get method start
	{
		return damageBonus;
	} // damageBonus get method end
	
	public int getCritOn() // critOn get method start
	{
		return critOn;
	} // critOn get method end
} // Character class end
