/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removelinetxt;

/**
 *
 * @author jeffersonbienaime
 */
public class OrgParam {
   
    private int LineStart;
    private int LineEnd;
    private int TotalLine;

    /**
     *
     * @param LineStart
     * @param LineEnd
     */
    public OrgParam(int LineStart, int LineEnd) {
        this.LineStart = LineStart;
        this.LineEnd = LineEnd;
    }

    public OrgParam(int TotalLine) {
        this.TotalLine = TotalLine;
    }     
    

    /**
     *
     * @return
     */
    public int getLineStart() {
        return LineStart;
    }

    /**
     *
     * @param LineStart
     */
    public void setLineStart(int LineStart) {
        this.LineStart = LineStart;
    }

    /**
     *
     * @return
     */
    public int getLineEnd() {
        return LineEnd;
    }

    /**
     *
     * @param LineEnd
     */
    public void setLineEnd(int LineEnd) {
        this.LineEnd = LineEnd;
    }

    /**
     *
     * @return
     */
    public int getTotalLine() {
        return TotalLine;
    }

    /**
     *
     * @param TotalLine
     */
    public void setTotalLine(int TotalLine) {
        this.TotalLine = TotalLine;
    }
               
}
