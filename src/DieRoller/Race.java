package DieRoller;

public abstract class Race
{
	// enum size list
	protected enum Size {SMALL, MEDIUM, LARGE}
	
	// class attributes
	private String name;
	private int str,
				dex,
				con,
				intel,
				wis,
				cha,
				baseSpeed;
	Size size;
	
	// constructor
	public Race(String n, int s, int d, int co, int i, int w, int ch, int bs, Size size)
	{
		setRace(n, s, d, co, i, w, ch, bs, size);
	} // constructor end
	
	// class set method start
	private void setRace(String n, int s, int d, int co, int i, int w, int ch, int bs, Size size)
	{
		setName(n);
		setStr(s);
		setDex(d);
		setCon(co);
		setInt(i);
		setWis(w);
		setCha(ch);
		setBaseSpeed(bs);
		setSize(size);
	} // class set method end
	
	// class set methods
	public void setName(String n) // name set method start
	{
		name = n;
	} // name set method end
	
	public void setStr(int s) // str set method start
	{
		str = s;
	} // str set method end
	
	public void setDex(int d) // dex set method start
	{
		dex = d;
	} // dex set method end
	
	public void setCon(int c) // con set method start
	{
		con = c;
	} // con set method end
	
	public void setInt(int i) // intel set method start
	{
		intel = i;
	} // intel set method end
	
	public void setWis(int w) // wis set method start
	{
		wis = w;
	} // wis set method end
	
	public void setCha(int c) // cha set method start
	{
		cha = c;
	} // cha set method end
	
	public void setBaseSpeed(int bs) // baseSpeed set method start
	{
		baseSpeed = bs;
	} // baseSpeed set method end
	
	public void setSize(Size s) // size set method start
	{
		size = s;
	} // size set method end
	
	// class get methods
	public String getName() // name get method start
	{
		return name;
	} // name get method end
	
	public int getStr() // str get method start
	{
		return str;
	} // str get method end
	
	public int getCon() // con get method start
	{
		return con;
	} // con get method end
	
	public int getDex() // dex get method start
	{
		return dex;
	} // dex get method end
	
	public int getInt() // intel get method start
	{
		return intel;
	} // intel get method end
	
	public int getWis() // wis get method start
	{
		return wis;
	} // wis get method end
	
	public int getCha() // cha get method start
	{
		return cha;
	} // cha get method end
	
	public int getBaseSpeed() // baseSpeed get method start
	{
		return baseSpeed;
	} // baseSpeed get method end
	
	public Size getSize() // size get method start
	{
		return size;
	} // size get method end
	
	@Override // overrides 
	public String toString() // toString method start
	{
		return name;
	} // toString method end
}
