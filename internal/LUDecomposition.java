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

   /** LU Decomposition.
   <p>
   For an m-by-n matrix A with m &gt;= n, the LU decomposition is an m-by-n
   unit lower triangular matrix L, an n-by-n upper triangular matrix U,
   and a permutation vector piv of length m so that A(piv,:) = L*U.
   If m &lt; n, then L is m-by-m and U is m-by-n.
   </p><p>
   The LU decompostion with pivoting always exists, even if the matrix is
   singular, so the constructor will never fail.  The primary use of the
   LU decomposition is in the solution of square systems of simultaneous
   linear equations.  This will fail if isNonsingular() returns false.
   */

class LUDecomposition
{

/* ------------------------
   Class variables
 * ------------------------ */

   /** Array for internal storage of decomposition.
   @serial internal array storage.
   */
   private double[][] LU;

   /** Row and column dimensions, and pivot sign.
   @serial column dimension.
   @serial row dimension.
   @serial pivot sign.
   */
   private int m, n, pivsign;

   /** Internal storage of pivot vector.
   @serial pivot vector.
   */
   private int[] piv;

/* ------------------------
   Constructor
 * ------------------------ */

   /** LU Decomposition
   @param  A   Rectangular matrix
   @return     Structure to access L, U and piv.
   */

   public LUDecomposition (Matrix A)
   {
       // Use a "left-looking", dot-product, Crout/Doolittle algorithm.

       LU = A.getArrayCopy();
       m = A.getRowDimension();
       n = A.getColumnDimension();
       piv = new int[m];
       for (int i = 0; i < m; i++)
       {
           piv[i] = i;
       }
       pivsign = 1;
       double[] LUrowi;
       double[] LUcolj = new double[m];

       // Outer loop.

       for (int j = 0; j < n; j++)
       {
           // Make a copy of the j-th column to localize references.

           for (int i = 0; i < m; i++)
           {
               LUcolj[i] = LU[i][j];
           }

           // Apply previous transformations.

           for (int i = 0; i < m; i++)
           {
               LUrowi = LU[i];

               // Most of the time is spent in the following dot product.

               int kmax = Math.min(i,j);
               double secondary_axis = 0.0;
               for (int k = 0; k < kmax; k++)
               {
                   secondary_axis += LUrowi[k]*LUcolj[k];
               }
               LUrowi[j] = LUcolj[i] -= secondary_axis;
           }

           // Find pivot and exchange if necessary.

           int p = j;
           for (int i = j+1; i < m; i++)
           {
               if (Math.abs(LUcolj[i]) > Math.abs(LUcolj[p]))
               {
                   p = i;
               }
           }
           if (p != j)
           {
               for (int k = 0; k < n; k++)
               {
                   double t = LU[p][k]; LU[p][k] = LU[j][k]; LU[j][k] = t;
               }
               int k = piv[p]; piv[p] = piv[j]; piv[j] = k;
               pivsign = -pivsign;
           }

           // Compute multipliers.

           if (j < m & LU[j][j] != 0.0)
           {
               for (int i = j+1; i < m; i++)
               {
                   LU[i][j] /= LU[j][j];
               }
           }
       }
   }

/* ------------------------
   Temporary, experimental code.
   ------------------------ *\

   \** LU Decomposition, computed by Gaussian elimination.
   <p>
   This constructor computes L and U with the "daxpy"-based elimination
   algorithm used in LINPACK and MATLAB.  In Java, we suspect the dot-product,
   Crout algorithm will be faster.  We have temporarily included this
   constructor until timing experiments confirm this suspicion.
   </p><p>
   @param  A             Rectangular matrix
   @param  linpackflag   Use Gaussian elimination.  Actual value ignored.
   @return               Structure to access L, U and piv.
   *\

   public LUDecomposition (Matrix A, int linpackflag)
   {
       // Initialize.
       LU = A.getArrayCopy();
       m = A.getRowDimension();
       n = A.getColumnDimension();
       piv = new int[m];
       for (int i = 0; i < m; i++)
       {
           piv[i] = i;
       }
       pivsign = 1;
       // Main loop.
       for (int k = 0; k < n; k++)
       {
           // Find pivot.
           int p = k;
           for (int i = k+1; i < m; i++)
           {
               if (Math.abs(LU[i][k]) > Math.abs(LU[p][k]))
               {
                   p = i;
               }
           }
           // Exchange if necessary.
           if (p != k)
           {
               for (int j = 0; j < n; j++)
               {
                   double t = LU[p][j]; LU[p][j] = LU[k][j]; LU[k][j] = t;
               }
               int t = piv[p]; piv[p] = piv[k]; piv[k] = t;
               pivsign = -pivsign;
           }
           // Compute multipliers and eliminate k-th column.
           if (LU[k][k] != 0.0)
           {
               for (int i = k+1; i < m; i++)
               {
                   LU[i][k] /= LU[k][k];
                   for (int j = k+1; j < n; j++)
                   {
                       LU[i][j] -= LU[i][k]*LU[k][j];
                   }
               }
           }
       }
   }

\* ------------------------
   End of temporary code.
 * ------------------------ */

/* ------------------------
   Public Methods
 * ------------------------ */

   /** Is the matrix nonsingular?
   @return     true if U, and hence A, is nonsingular.
   */
   public boolean isNonsingular ()
   {
       for (int j = 0; j < n; j++)
       {
           if (LU[j][j] == 0)
               return false;
       }
       return true;
   }

   /** Return lower triangular factor
   @return     L
   */

   public Matrix getL ()
   {
       Matrix X = new Matrix(m,n);
       double[][] L = X.getArray();
       for (int i = 0; i < m; i++)
       {
           for (int j = 0; j < n; j++)
           {
               if (i > j)
               {
                   L[i][j] = LU[i][j];
               }
               else if (i == j)
               {
                   L[i][j] = 1.0;
               }
               else
               {
                   L[i][j] = 0.0;
               }
           }
       }
       return X;
   }

   /** Return upper triangular factor
   @return     U
   */

   public Matrix getU ()
   {
       Matrix X = new Matrix(n,n);
       double[][] U = X.getArray();
       for (int i = 0; i < n; i++)
       {
           for (int j = 0; j < n; j++)
           {
               if (i <= j)
               {
                   U[i][j] = LU[i][j];
               }
               else
               {
                   U[i][j] = 0.0;
               }
           }
       }
       return X;
   }

   /** Return pivot permutation vector
   @return     piv
   */
   public int[] getPivot ()
   {
       int[] p = new int[m];
       for (int i = 0; i < m; i++)
       {
           p[i] = piv[i];
       }
       return p;
   }

   /** Return pivot permutation vector as a one-dimensional double array
   @return     (double) piv
   */
   public double[] getDoublePivot ()
   {
       double[] vals = new double[m];
       for (int i = 0; i < m; i++)
       {
           vals[i] = (double) piv[i];
       }
       return vals;
   }

   /** Determinant
   @return     det(A)
   @exception  IllegalArgumentException  Matrix must be square
   */
   public double det ()
   {
       if (m != n)
       {
           throw new IllegalArgumentException("Matrix must be square.");
       }
       double d = (double) pivsign;
       for (int j = 0; j < n; j++)
       {
           d *= LU[j][j];
       }
       return d;
   }

   /** Solve A*X = B
   @param  B   A Matrix with as many rows as A and any number of columns.
   @return     X so that L*U*X = B(piv,:)
   @exception  IllegalArgumentException Matrix row dimensions must agree.
   @exception  RuntimeException  Matrix is singular.
   */
   public Matrix solve (Matrix B)
   {
       if (B.getRowDimension() != m)
       {
           throw new IllegalArgumentException("Matrix row dimensions must agree.");
       }
       if (!this.isNonsingular())
       {
           throw new RuntimeException("Matrix is singular.");
       }

       // Copy right hand side with pivoting
       int nx = B.getColumnDimension();
       Matrix Xmat = B.getMatrix(piv,0,nx-1);
       double[][] X = Xmat.getArray();

       // Solve L*Y = B(piv,:)
       for (int k = 0; k < n; k++)
       {
           for (int i = k+1; i < n; i++)
           {
               for (int j = 0; j < nx; j++)
               {
                   X[i][j] -= X[k][j]*LU[i][k];
               }
           }
       }
       // Solve U*X = Y;
       for (int k = n-1; k >= 0; k--)
       {
           for (int j = 0; j < nx; j++)
           {
               X[k][j] /= LU[k][k];
           }
           for (int i = 0; i < k; i++)
           {
               for (int j = 0; j < nx; j++)
               {
                   X[i][j] -= X[k][j]*LU[i][k];
               }
           }
       }
       return Xmat;
   }
}
