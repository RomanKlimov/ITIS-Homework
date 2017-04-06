package data;

public interface DataStorage {
    public void setPath(String path) throws DbException;
    public Object[] getFiles() throws DbException;
    public void deleteFile(int index) throws DbException;
    public void scanFiles() throws DbException;
}
