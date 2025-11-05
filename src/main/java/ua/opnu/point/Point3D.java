package ua.opnu.point;

public class Point3D extends Point {
    private int z;

    public Point3D() {
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public double distanceFromOrigin() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    @Override
    public double distance(Point p) {
        if (p instanceof Point3D) {
            Point3D p3d = (Point3D) p;

            int dx = this.x - p3d.x;
            int dy = this.y - p3d.y;
            int dz = this.z - p3d.z;

            return Math.sqrt(dx * dx + dy * dy + dz * dz);
        } else {
            return super.distance(p);
        }
    }

    @Override
    public String toString() {
        return "Point3D(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }
}
