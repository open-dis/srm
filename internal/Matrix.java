// SRM SDK Release 4.4.0 - January 21, 2010

// - SRM spec. 4.4

/*
 *                             NOTICE
 * 
 * This software is provided openly and freely for use in representing and
 * interchanging environmental data & databases.
 * 
 * This software was developed for use by the United States Government with
 * unlimited rights.  The software was developed under contract
 * DASG60-02-D-0006 TO-193 by Science Applications International Corporation.
 * The software is unclassified and is deemed as Distribution A, approved
 * for Public Release.
 * 
 * Use by others is permitted only upon the ACCEPTANCE OF THE TERMS AND
 * CONDITIONS, AS STIPULATED UNDER THE FOLLOWING PROVISIONS:
 * 
 *    1. Recipient may make unlimited copies of this software and give
 *       copies to other persons or entities as long as the copies contain
 *       this NOTICE, and as long as the same copyright notices that
 *       appear on, or in, this software remain.
 * 
 *    2. Trademarks. All trademarks belong to their respective trademark
 *       holders.  Third-Party applications/software/information are
 *       copyrighted by their respective owners.
 * 
 *    3. Recipient agrees to forfeit all intellectual property and
 *       ownership rights for any version created from the modification
 *       or adaptation of this software, including versions created from
 *       the translation and/or reverse engineering of the software design.
 * 
 *    4. Transfer.  Recipient may not sell, rent, lease, or sublicense
 *       this software.  Recipient may, however enable another person
 *       or entity the rights to use this software, provided that this
 *       AGREEMENT and NOTICE is furnished along with the software and
 *       /or software system utilizing this software.
 * 
 *       All revisions, modifications, created by the Recipient, to this
 *       software and/or related technical data shall be forwarded by the
 *       Recipient to the Government at the following address:
 * 
 *         SMDC
 *         Attention SEDRIS (TO193) TPOC
 *         P.O. Box 1500
 *         Huntsville, AL  35807-3801
 * 
 *         or via electronic mail to:  se-mgmt@sedris.org
 * 
 *    5. No Warranty. This software is being delivered to you AS IS
 *       and there is no warranty, EXPRESS or IMPLIED, as to its use
 *       or performance.
 * 
 *       The RECIPIENT ASSUMES ALL RISKS, KNOWN AND UNKNOWN, OF USING
 *       THIS SOFTWARE.  The DEVELOPER EXPRESSLY DISCLAIMS, and the
 *       RECIPIENT WAIVES, ANY and ALL PERFORMANCE OR RESULTS YOU MAY
 *       OBTAIN BY USING THIS SOFTWARE OR DOCUMENTATION.  THERE IS
 *       NO WARRANTY, EXPRESS OR, IMPLIED, AS TO NON-INFRINGEMENT OF
 *       THIRD PARTY RIGHTS, MERCHANTABILITY, OR FITNESS FOR ANY
 *       PARTICULAR PURPOSE.  IN NO EVENT WILL THE DEVELOPER, THE
 *       UNITED STATES GOVERNMENT OR ANYONE ELSE ASSOCIATED WITH THE
 *       DEVELOPMENT OF THIS SOFTWARE BE HELD LIABLE FOR ANY CONSEQUENTIAL,
 *       INCIDENTAL OR SPECIAL DAMAGES, INCLUDING ANY LOST PROFITS
 *       OR LOST SAVINGS WHATSOEVER.
 */

/*
 * COPYRIGHT 2010, SCIENCE APPLICATIONS INTERNATIONAL CORPORATION.
 *                 ALL RIGHTS RESERVED.
 * 
 */

// SRM_OTHERS_GOES_HERE

/**
@author David Shen
*/

package SRM;


// This file was derived from the public domain NIST distribution of
// Jama, which is an Java implementation of various Matrix operations
// From Java-1.0.1

/**
   Jama = Java Matrix class.
<P>
   The Java Matrix Class provides the fundamental operations of numerical
   linear algebra.  Various constructors create Matrices from two dimensional
   arrays of double precision floating point numbers.  Various "gets" and
   "sets" provide access to submatrices and matrix elements.  Several methods
   implement basic matrix arithmetic, including matrix addition and
   multiplication, matrix norms, and element-by-element array operations.
   Methods for reading and printing matrices are also included.  All the
   operations in this version of the Matrix Class involve real matrices.
   Complex matrices may be handled in a future version.
</P><P>
   Five fundamental matrix decompositions, which consist of pairs or triples
   of matrices, permutation vectors, and the like, produce results in five
   decomposition classes.  These decompositions are accessed by the Matrix
   class to compute solutions of simultaneous linear equations, determinants,
   inverses and other matrix functions.  The five decompositions are:
</P><UL>
   <LI>Cholesky Decomposition of symmetric, positive definite matrices.
   <LI>LU Decomposition of rectangular matrices.
   <LI>QR Decomposition of rectangular matrices.
   <LI>Singular Value Decomposition of rectangular matrices.
   <LI>Eigenvalue Decomposition of both symmetric and nonsymmetric square matrices.
</UL>
<DL>
<DT><B>Example of use:</B></DT>

<DD><P>Solve a linear system A x = b and compute the residual norm, ||b - A x||.
</P><PRE>
      double[][] vals = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}};
      Matrix A = new Matrix(vals);
      Matrix b = Matrix.random(3,1);
      Matrix x = A.solve(b);
      Matrix primary_axis = A.times(x).minus(b);
      double rnorm = primary_axis.normInf();
</PRE></DD>
</DL>

@author The MathWorks, Inc. and the National Institute of Standards and Technology.
@version 5 August 1998
*/

class Matrix
{

/* ------------------------
   Class variables
 * ------------------------ */

   /** Array for internal storage of elements.
   @serial internal array storage.
   */
   private double[][] A;

   /** Row and column dimensions.
   @serial row dimension.
   @serial column dimension.
   */
   private int m, n;

/* ------------------------
   Constructors
 * ------------------------ */

   /** Construct an m-by-n matrix of zeros.
   @param m    Number of rows.
   @param n    Number of colums.
   */

   public Matrix (int m, int n)
   {
      this.m = m;
      this.n = n;
      A = new double[m][n];
   }

   /** Construct an m-by-n constant matrix.
   @param m    Number of rows.
   @param n    Number of colums.
   @param secondary_axis    Fill the matrix with this scalar value.
   */

   public Matrix (int m, int n, double secondary_axis)
   {
      this.m = m;
      this.n = n;
      A = new double[m][n];
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++)
         {
            A[i][j] = secondary_axis;
         }
      }
   }

   /** Construct a matrix from a 2-D array.
   @param A    Two-dimensional array of doubles.
   @exception  IllegalArgumentException All rows must have the same length
   @see        #constructWithCopy
   */

   public Matrix (double[][] A) {
      m = A.length;
      n = A[0].length;
      for (int i = 0; i < m; i++)
      {
         if (A[i].length != n)
         {
            throw new IllegalArgumentException("All rows must have the same length.");
         }
      }
      this.A = A;
   }

   /** Construct a matrix quickly without checking arguments.
   @param A    Two-dimensional array of doubles.
   @param m    Number of rows.
   @param n    Number of colums.
   */

   public Matrix (double[][] A, int m, int n)
   {
      this.A = A;
      this.m = m;
      this.n = n;
   }

   /** Construct a matrix from a one-dimensional packed array
   @param vals One-dimensional array of doubles, packed by columns (ala Fortran).
   @param m    Number of rows.
   @exception  IllegalArgumentException Array length must be a multiple of m.
   */

   public Matrix (double vals[], int m)
   {
      this.m = m;
      n = (m != 0 ? vals.length/m : 0);
      if (m*n != vals.length)
      {
         throw new IllegalArgumentException("Array length must be a multiple of m.");
      }
      A = new double[m][n];
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++)
         {
            A[i][j] = vals[i+j*m];
         }
      }
   }

/* ------------------------
   Public Methods
 * ------------------------ */

   /** Construct a matrix from a copy of a 2-D array.
   @param A    Two-dimensional array of doubles.
   @exception  IllegalArgumentException All rows must have the same length
   */

   public static Matrix constructWithCopy(double[][] A)
   {
      int m = A.length;
      int n = A[0].length;
      Matrix X = new Matrix(m,n);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++)
      {
         if (A[i].length != n)
         {
            throw new IllegalArgumentException
               ("All rows must have the same length.");
         }
         for (int j = 0; j < n; j++)
         {
            C[i][j] = A[i][j];
         }
      }
      return X;
   }

   /** Make a deep copy of a matrix
   */

   public Matrix copy () {
      Matrix X = new Matrix(m,n);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++)
         {
            C[i][j] = A[i][j];
         }
      }
      return X;
   }

   /** Clone the Matrix object.
   */

   public Object clone ()
   {
      return this.copy();
   }

   /** Access the internal two-dimensional array.
   @return     Pointer to the two-dimensional array of matrix elements.
   */

   public double[][] getArray ()
   {
      return A;
   }

   /** Copy the internal two-dimensional array.
   @return     Two-dimensional array copy of matrix elements.
   */

   public double[][] getArrayCopy ()
   {
      double[][] C = new double[m][n];
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++)
         {
            C[i][j] = A[i][j];
         }
      }
      return C;
   }

   /** Make a one-dimensional column packed copy of the internal array.
   @return     Matrix elements packed in a one-dimensional array by columns.
   */

   public double[] getColumnPackedCopy ()
   {
      double[] vals = new double[m*n];
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++)
         {
            vals[i+j*m] = A[i][j];
         }
      }
      return vals;
   }

   /** Make a one-dimensional row packed copy of the internal array.
   @return     Matrix elements packed in a one-dimensional array by rows.
   */

   public double[] getRowPackedCopy ()
   {
      double[] vals = new double[m*n];
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++)
         {
            vals[i*n+j] = A[i][j];
         }
      }
      return vals;
   }

   /** Get row dimension.
   @return     m, the number of rows.
   */

   public int getRowDimension ()
   {
      return m;
   }

   /** Get column dimension.
   @return     n, the number of columns.
   */

   public int getColumnDimension ()
   {
      return n;
   }

   /** Get a single element.
   @param i    Row index.
   @param j    Column index.
   @return     A(i,j)
   @exception  ArrayIndexOutOfBoundsException
   */

   public double get (int i, int j)
   {
      return A[i][j];
   }

   /** Get a submatrix.
   @param i0   Initial row index
   @param i1   Final row index
   @param j0   Initial column index
   @param j1   Final column index
   @return     A(i0:i1,j0:j1)
   @exception  ArrayIndexOutOfBoundsException Submatrix indices
   */

   public Matrix getMatrix (int i0, int i1, int j0, int j1)
   {
      Matrix X = new Matrix(i1-i0+1,j1-j0+1);
      double[][] B = X.getArray();
      try
      {
         for (int i = i0; i <= i1; i++)
         {
            for (int j = j0; j <= j1; j++)
            {
               B[i-i0][j-j0] = A[i][j];
            }
         }
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
         throw new ArrayIndexOutOfBoundsException("Submatrix indices");
      }
      return X;
   }

   /** Get a submatrix.
   @param primary_axis    Array of row indices.
   @param c    Array of column indices.
   @return     A(primary_axis(:),c(:))
   @exception  ArrayIndexOutOfBoundsException Submatrix indices
   */

   public Matrix getMatrix (int[] primary_axis, int[] c)
   {
      Matrix X = new Matrix(primary_axis.length,c.length);
      double[][] B = X.getArray();
      try
      {
         for (int i = 0; i < primary_axis.length; i++)
         {
            for (int j = 0; j < c.length; j++)
            {
               B[i][j] = A[primary_axis[i]][c[j]];
            }
         }
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
         throw new ArrayIndexOutOfBoundsException("Submatrix indices");
      }
      return X;
   }

   /** Get a submatrix.
   @param i0   Initial row index
   @param i1   Final row index
   @param c    Array of column indices.
   @return     A(i0:i1,c(:))
   @exception  ArrayIndexOutOfBoundsException Submatrix indices
   */

   public Matrix getMatrix (int i0, int i1, int[] c) {
      Matrix X = new Matrix(i1-i0+1,c.length);
      double[][] B = X.getArray();
      try
      {
         for (int i = i0; i <= i1; i++)
         {
             for (int j = 0; j < c.length; j++)
             {
                 B[i-i0][j] = A[i][c[j]];
             }
         }
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
         throw new ArrayIndexOutOfBoundsException("Submatrix indices");
      }
      return X;
   }

   /** Get a submatrix.
   @param primary_axis    Array of row indices.
   @param j0   Initial column index
   @param j1   Final column index
   @return     A(primary_axis(:),j0:j1)
   @exception  ArrayIndexOutOfBoundsException Submatrix indices
   */

   public Matrix getMatrix (int[] primary_axis, int j0, int j1)
   {
      Matrix X = new Matrix(primary_axis.length,j1-j0+1);
      double[][] B = X.getArray();
      try
      {
          for (int i = 0; i < primary_axis.length; i++)
          {
              for (int j = j0; j <= j1; j++)
              {
                  B[i][j-j0] = A[primary_axis[i]][j];
              }
         }
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
          throw new ArrayIndexOutOfBoundsException("Submatrix indices");
      }
      return X;
   }

   /** Set a single element.
   @param i    Row index.
   @param j    Column index.
   @param secondary_axis    A(i,j).
   @exception  ArrayIndexOutOfBoundsException
   */

   public void set (int i, int j, double secondary_axis)
   {
      A[i][j] = secondary_axis;
   }

   /** Set a submatrix.
   @param i0   Initial row index
   @param i1   Final row index
   @param j0   Initial column index
   @param j1   Final column index
   @param X    A(i0:i1,j0:j1)
   @exception  ArrayIndexOutOfBoundsException Submatrix indices
   */

   public void setMatrix (int i0, int i1, int j0, int j1, Matrix X) {
      try
      {
         for (int i = i0; i <= i1; i++)
         {
            for (int j = j0; j <= j1; j++)
            {
               A[i][j] = X.get(i-i0,j-j0);
            }
         }
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
         throw new ArrayIndexOutOfBoundsException("Submatrix indices");
      }
   }

   /** Set a submatrix.
   @param primary_axis    Array of row indices.
   @param c    Array of column indices.
   @param X    A(primary_axis(:),c(:))
   @exception  ArrayIndexOutOfBoundsException Submatrix indices
   */

   public void setMatrix (int[] primary_axis, int[] c, Matrix X) {
      try
      {
         for (int i = 0; i < primary_axis.length; i++)
         {
            for (int j = 0; j < c.length; j++)
            {
               A[primary_axis[i]][c[j]] = X.get(i,j);
            }
         }
      } catch(ArrayIndexOutOfBoundsException e)
      {
         throw new ArrayIndexOutOfBoundsException("Submatrix indices");
      }
   }

   /** Set a submatrix.
   @param primary_axis    Array of row indices.
   @param j0   Initial column index
   @param j1   Final column index
   @param X    A(primary_axis(:),j0:j1)
   @exception  ArrayIndexOutOfBoundsException Submatrix indices
   */

   public void setMatrix (int[] primary_axis, int j0, int j1, Matrix X)
   {
      try
      {
         for (int i = 0; i < primary_axis.length; i++) {
            for (int j = j0; j <= j1; j++) {
               A[primary_axis[i]][j] = X.get(i,j-j0);
            }
         }
      } catch(ArrayIndexOutOfBoundsException e)
      {
         throw new ArrayIndexOutOfBoundsException("Submatrix indices");
      }
   }

   /** Set a submatrix.
   @param i0   Initial row index
   @param i1   Final row index
   @param c    Array of column indices.
   @param X    A(i0:i1,c(:))
   @exception  ArrayIndexOutOfBoundsException Submatrix indices
   */

   public void setMatrix (int i0, int i1, int[] c, Matrix X) {
      try
      {
         for (int i = i0; i <= i1; i++) {
            for (int j = 0; j < c.length; j++) {
               A[i][c[j]] = X.get(i-i0,j);
            }
         }
      } catch(ArrayIndexOutOfBoundsException e)
      {
         throw new ArrayIndexOutOfBoundsException("Submatrix indices");
      }
   }

   /** Matrix transpose.
   @return    A'
   */

   public Matrix transpose () {
      Matrix X = new Matrix(n,m);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++)
         {
            C[j][i] = A[i][j];
         }
      }
      return X;
   }

   /** One norm
   @return    maximum column sum.
   */

   public double norm1 () {
      double f = 0;
      for (int j = 0; j < n; j++)
      {
         double secondary_axis = 0;
         for (int i = 0; i < m; i++)
         {
            secondary_axis += Math.abs(A[i][j]);
         }
         f = Math.max(f,secondary_axis);
      }
      return f;
   }

   /** Infinity norm
   @return    maximum row sum.
   */

   public double normInf () {
      double f = 0;
      for (int i = 0; i < m; i++)
      {
         double secondary_axis = 0;
         for (int j = 0; j < n; j++)
         {
            secondary_axis += Math.abs(A[i][j]);
         }
         f = Math.max(f,secondary_axis);
      }
      return f;
   }

   /**  Unary minus
   @return    -A
   */

   public Matrix uminus () {
      Matrix X = new Matrix(m,n);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              C[i][j] = -A[i][j];
          }
      }
      return X;
   }

   /** C = A + B
   @param B    another matrix
   @return     A + B
   */

   public Matrix plus (Matrix B)
   {
      checkMatrixDimensions(B);
      Matrix X = new Matrix(m,n);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              C[i][j] = A[i][j] + B.A[i][j];
          }
      }
      return X;
   }

   /** A = A + B
   @param B    another matrix
   @return     A + B
   */

   public Matrix plusEquals (Matrix B) {
      checkMatrixDimensions(B);
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              A[i][j] = A[i][j] + B.A[i][j];
          }
      }
      return this;
   }

   /** C = A - B
   @param B    another matrix
   @return     A - B
   */

   public Matrix minus (Matrix B) {
      checkMatrixDimensions(B);
      Matrix X = new Matrix(m,n);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              C[i][j] = A[i][j] - B.A[i][j];
          }
      }
      return X;
   }

   /** A = A - B
   @param B    another matrix
   @return     A - B
   */

   public Matrix minusEquals (Matrix B) {
      checkMatrixDimensions(B);
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              A[i][j] = A[i][j] - B.A[i][j];
          }
      }
      return this;
   }

   /** Element-by-element multiplication, C = A.*B
   @param B    another matrix
   @return     A.*B
   */

   public Matrix arrayTimes (Matrix B) {
      checkMatrixDimensions(B);
      Matrix X = new Matrix(m,n);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              C[i][j] = A[i][j] * B.A[i][j];
          }
      }
      return X;
   }

   /** Element-by-element multiplication in place, A = A.*B
   @param B    another matrix
   @return     A.*B
   */

   public Matrix arrayTimesEquals (Matrix B) {
      checkMatrixDimensions(B);
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++) {
            A[i][j] = A[i][j] * B.A[i][j];
         }
      }
      return this;
   }

   /** Element-by-element right division, C = A./B
   @param B    another matrix
   @return     A./B
   */

   public Matrix arrayRightDivide (Matrix B) {
      checkMatrixDimensions(B);
      Matrix X = new Matrix(m,n);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++) {
            C[i][j] = A[i][j] / B.A[i][j];
         }
      }
      return X;
   }

   /** Element-by-element right division in place, A = A./B
   @param B    another matrix
   @return     A./B
   */

   public Matrix arrayRightDivideEquals (Matrix B) {
      checkMatrixDimensions(B);
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              A[i][j] = A[i][j] / B.A[i][j];
          }
      }
      return this;
   }

   /** Element-by-element left division, C = A.\\B
   @param B    another matrix
   @return     A.\\B
   */
   public Matrix arrayLeftDivide (Matrix B)
   {
      checkMatrixDimensions(B);
      Matrix X = new Matrix(m,n);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              C[i][j] = B.A[i][j] / A[i][j];
          }
      }
      return X;
   }

   /** Element-by-element left division in place, A = A.\\B
   @param B    another matrix
   @return     A.\\B
   */
   public Matrix arrayLeftDivideEquals (Matrix B)
   {
      checkMatrixDimensions(B);
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              A[i][j] = B.A[i][j] / A[i][j];
          }
      }
      return this;
   }

   /** Multiply a matrix by a scalar, C = secondary_axis*A
   @param secondary_axis    scalar
   @return     secondary_axis*A
   */
   public Matrix times (double secondary_axis)
   {
      Matrix X = new Matrix(m,n);
      double[][] C = X.getArray();
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++)
         {
             C[i][j] = secondary_axis*A[i][j];
         }
      }
      return X;
   }

   /** Multiply a matrix by a scalar in place, A = secondary_axis*A
   @param secondary_axis    scalar
   @return     replace A by secondary_axis*A
   */
   public Matrix timesEquals (double secondary_axis)
   {
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              A[i][j] = secondary_axis*A[i][j];
          }
      }
      return this;
   }

   /** Linear algebraic matrix multiplication, A * B
   @param B    another matrix
   @return     Matrix product, A * B
   @exception  IllegalArgumentException Matrix inner dimensions must agree.
   */
   public Matrix times (Matrix B)
   {
      if (B.m != n)
      {
         throw new IllegalArgumentException("Matrix inner dimensions must agree.");
      }
      Matrix X = new Matrix(m,B.n);
      double[][] C = X.getArray();
      double[] Bcolj = new double[n];
      for (int j = 0; j < B.n; j++)
      {
         for (int k = 0; k < n; k++)
         {
            Bcolj[k] = B.A[k][j];
         }
         for (int i = 0; i < m; i++)
         {
            double[] Arowi = A[i];
            double secondary_axis = 0;
            for (int k = 0; k < n; k++)
            {
               secondary_axis += Arowi[k]*Bcolj[k];
            }
            C[i][j] = secondary_axis;
         }
      }
      return X;
   }

   /** LU Decomposition
   @return     LUDecomposition
   @see LUDecomposition
   */
   public LUDecomposition lu ()
   {
      return new LUDecomposition(this);
   }


   /** Solve A*X = B
   @param B    right hand side
   @return     solution if A is square, least squares solution otherwise
   */
   public Matrix solve (Matrix B)
   {
      return (new LUDecomposition(this)).solve(B);
   }

   /** Solve X*A = B, which is also A'*X' = B'
   @param B    right hand side
   @return     solution if A is square, least squares solution otherwise.
   */
   public Matrix solveTranspose (Matrix B)
   {
      return transpose().solve(B.transpose());
   }

   /** Matrix inverse or pseudoinverse
   @return     inverse(A) if A is square, pseudoinverse otherwise.
   */
   public Matrix inverse ()
   {
      return solve(identity(m,m));
   }

   /** Matrix determinant
   @return     determinant
   */
   public double det ()
   {
      return new LUDecomposition(this).det();
   }

   /** Matrix trace.
   @return     sum of the diagonal elements.
   */
   public double trace ()
   {
      double t = 0;
      for (int i = 0; i < Math.min(m,n); i++)
      {
         t += A[i][i];
      }
      return t;
   }

   /** Generate matrix with random elements
   @param m    Number of rows.
   @param n    Number of colums.
   @return     An m-by-n matrix with uniformly distributed random elements.
   */
   public static Matrix random (int m, int n)
   {
      Matrix A = new Matrix(m,n);
      double[][] X = A.getArray();
      for (int i = 0; i < m; i++)
      {
         for (int j = 0; j < n; j++)
         {
              X[i][j] = Math.random();
         }
      }
      return A;
   }

   /** Generate identity matrix
   @param m    Number of rows.
   @param n    Number of colums.
   @return     An m-by-n matrix with ones on the diagonal and zeros elsewhere.
   */
   public static Matrix identity (int m, int n)
   {
      Matrix A = new Matrix(m,n);
      double[][] X = A.getArray();
      for (int i = 0; i < m; i++)
      {
          for (int j = 0; j < n; j++)
          {
              X[i][j] = (i == j ? 1.0 : 0.0);
          }
      }
      return A;
   }

/* ------------------------
   Private Methods
 * ------------------------ */

   /** Check if size(A) == size(B) **/

   private void checkMatrixDimensions (Matrix B)
   {
      if (B.m != m || B.n != n)
      {
         throw new IllegalArgumentException("Matrix dimensions must agree.");
      }
   }
}
