package javaawt;

/** 
 * Just dummy value holders
 */
public class AlphaComposite extends Composite
{
	/**
	 * The source is composited over the destination
	 * (Porter-Duff Source Over Destination rule).
	 *<p>
	 * <em>F<sub>s</sub></em> = 1 and <em>F<sub>d</sub></em> = (1-<em>A<sub>s</sub></em>), thus:
	 *<pre>
	 *  <em>A<sub>r</sub></em> = <em>A<sub>s</sub></em> + <em>A<sub>d</sub></em>*(1-<em>A<sub>s</sub></em>)
	 *  <em>C<sub>r</sub></em> = <em>C<sub>s</sub></em> + <em>C<sub>d</sub></em>*(1-<em>A<sub>s</sub></em>)
	 *</pre>
	 */
	public static final int SRC_OVER = 0;
	/**
	* The part of the source lying inside of the destination replaces
	* the destination
	* (Porter-Duff Source In Destination rule).
	*<p>
	* <em>F<sub>s</sub></em> = <em>A<sub>d</sub></em> and <em>F<sub>d</sub></em> = 0, thus:
	*<pre>
	*  <em>A<sub>r</sub></em> = <em>A<sub>s</sub></em>*<em>A<sub>d</sub></em>
	*  <em>C<sub>r</sub></em> = <em>C<sub>s</sub></em>*<em>A<sub>d</sub></em>
	*</pre>
	*/
	public static final int SRC_IN = 1;

	private int type = SRC_OVER;
	private float alpha = 1f;

	public AlphaComposite(int type, float alpha)
	{
		this.type = type;
		this.alpha = type == SRC_IN ? 1f : alpha;
	}

	public int getType()
	{
		return type;
	}

	public float getAlpha()
	{
		return alpha;
	}

	public static Composite getInstance(int type, float alpha)
	{
		return new AlphaComposite(type, alpha);
	}

	public static Composite getInstance(int type)
	{
		return new AlphaComposite(type, 1f);
	}

}
