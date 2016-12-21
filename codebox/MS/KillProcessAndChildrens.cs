using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Security.Cryptography;
using System.Threading;
using System.Xml;
using System.Diagnostics;
using System.Management;

namespace ConsoleApplication1
{
    class Program
    {
        private static void KillProcessAndChildrens(int pid)
        {
            ManagementObjectSearcher processSearcher = new ManagementObjectSearcher
              ("Select * From Win32_Process Where ParentProcessID=" + pid);
            ManagementObjectCollection processCollection = processSearcher.Get();

            try
            {
                Process proc = Process.GetProcessById(pid);
                if (!proc.HasExited) proc.Kill();
            }
            catch (ArgumentException)
            {
                // Process already exited.
            }

            if (processCollection != null)
            {
                foreach (ManagementObject mo in processCollection)
                {
                    KillProcessAndChildrens(Convert.ToInt32(mo["ProcessID"])); //kill child processes(also kills childrens of childrens etc.)
                }
            }
        }

        public static void ProcessCommandLine(string command)
        {
            command += " & exit";
            // logger.Log(LogLevel.Info, "ProcessCommandLine " + command);
            ProcessStartInfo info = new ProcessStartInfo("cmd.exe");
            info.Arguments = "/c " + command;
            Process process=Process.Start(info);

            process.WaitForExit(2000);
            process.Refresh();
            if (!process.HasExited)
            {
                KillProcessAndChildrens(process.Id);
            }

            process.WaitForExit();

            if (process.ExitCode != 0)
            {
                System.Console.WriteLine("fail to excute");
            }
        }
        static void Main(string[] args)
        {
            ProcessCommandLine("D:\\zookeeper-3.4.5\\bin\\zkCli.cmd");

            Console.ReadKey();
        }
    }
}
