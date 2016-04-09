package rander.com.bezier.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by rander on 16-4-3.
 */
public class BezierView extends View{
    float rate = 0.551915024494f;
    int radius = 100;
    Point p0 = new Point(0,radius);
    Point p1 = new Point((int) (radius*rate),radius);
    Point p2 = new Point(radius,(int) (radius*rate));
    Point p3 = new Point(radius,0);

    Point p4 = new Point(radius,-(int) (radius*rate));
    Point p5 = new Point((int) (radius*rate),-radius);
    Point p6 = new Point(0,-radius);
    Point p7 = new Point(-(int) (radius*rate),-radius);

    Point p8 = new Point(-radius,-(int) (radius*rate));
    Point p9 = new Point(-radius,0);
    Point p10 = new Point(-radius,(int) (radius*rate));
    Point p11 = new Point(-(int) (radius*rate),radius);

    Path mPath;
    Paint mPaint;

    public BezierView(Context context) {
        this(context, null);
    }

    public BezierView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public BezierView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPath = new Path();
        mPath.moveTo(p0.x, p0.y);
        mPath.cubicTo(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
        mPath.cubicTo(p4.x, p4.y, p5.x, p5.y, p6.x, p6.y);
        mPath.cubicTo(p7.x, p7.y, p8.x, p8.y, p9.x, p9.y);
        mPath.cubicTo(p10.x, p10.y, p11.x, p11.y, p0.x, p0.y);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        canvas.translate(300, 300);

        canvas.drawPath(mPath,mPaint);

        canvas.restore();
    }
}
